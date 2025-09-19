package th.co.ais.rpt.batch.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class ReportEnDecryptor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StandardPBEStringEncryptor myFirstEncryptor = null;
		String type = null;
		String input = null;
		try {
			if (args.length < 2) {
				System.out.println("At least 2 arguments are required: Encrypt or Dcrypt (E/D), text input.");
				System.exit(1);
			}
			
			myFirstEncryptor = new StandardPBEStringEncryptor();
			myFirstEncryptor.setProvider(new BouncyCastleProvider());
			myFirstEncryptor.setAlgorithm("PBEWITHSHA256AND128BITAES-CBC-BC");
			myFirstEncryptor.setPassword("jasypt");
			
			type = args[0];
			input = args[1];
			if(type.trim().equalsIgnoreCase("E")){
				System.out.println("Encrypt " + input + " to " + myFirstEncryptor.encrypt(input));
			} else if(type.trim().equalsIgnoreCase("D")){
				System.out.println("Decrypt " + input + " to " + myFirstEncryptor.decrypt(input));
			} else {
				System.out.println("No Type of Application : " + type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			myFirstEncryptor = null;
			type = null;
			input = null;
		}

	}

}
