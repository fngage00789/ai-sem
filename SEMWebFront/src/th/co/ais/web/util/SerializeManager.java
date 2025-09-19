package th.co.ais.web.util;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeManager {
	
	public static void Serialize(Object obj, String filename){
		 FileOutputStream fos = null;
	     ObjectOutputStream _out = null;
	     try
	     { 
	       System.out.println("Write file to "+filename);
	       fos = new FileOutputStream(filename);
	       _out = new ObjectOutputStream(fos);
	       _out.writeObject(obj);
	       _out.close();
	     }
	     catch(IOException ex)
	     {
	       ex.printStackTrace();
	     }
	}
	
	public static Object Deserialize(String filename){
		Object obj=null;
		
		FileInputStream fis = null;
		ObjectInputStream in = null;
	   try
	   {
		 System.out.println("Deserialize from "+filename);
	     fis = new FileInputStream(filename);
	     in = new ObjectInputStream(fis);
	     obj = in.readObject();
	     in.close();
	   }
	   catch(IOException ex)
	   {
	     ex.printStackTrace();
	   }
	   catch(ClassNotFoundException ex)
	   {
	     ex.printStackTrace();
	   }		
		return obj;
	}
	
	
	public static void write(Object f, String filename) throws Exception{
        XMLEncoder encoder =
           new XMLEncoder(
              new BufferedOutputStream(
                new FileOutputStream(filename)));
        System.out.println("Write to "+filename);
        encoder.writeObject(f);
        encoder.close();
    }
	
	public static Object read(String filename) throws Exception {
        Object obj = null;
		XMLDecoder decoder =
            new XMLDecoder(new BufferedInputStream(
                new FileInputStream(filename)));
		System.out.println("Read from "+filename);
		obj = decoder.readObject();
        decoder.close();
        return obj;
    }
}
