package th.co.ais.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author dittt150
 *
 * Ditthawat Tanasiriwat
 */
public class StringHelper 
{
	public static final String ZERO = "0";
	public static final String ENCODING_UTF8 = "UTF-8";
	public static final String ENCODING_TIS620 = "TIS620";
	public static final String ENCODING_MS874 = "MS874";
	
	public static String valueOf(long n, int len)
	{
		StringBuffer sb = new StringBuffer();
		String s = String.valueOf(n);
		if (len != 0)
		{
			for (int i = len - s.length(); i > 0; i--)
			{
				sb.append("0");
			}
		}
		sb.append(s);
		return sb.toString();
	}
	
	public static boolean isNumeric(String s) 
	{
		  final char[] chars = s.toCharArray();
		  for (int x = 0; x < chars.length; x++)
		  {
		    final char c = chars[x];
		    if ((c >= '0') && (c <= '9')) continue; // numeric
		    return false;
		  }
		  return true;
	}
	
	public static boolean isAlpha(String s) 
	{
		  final char[] chars = s.toCharArray();
		  for (int x = 0; x < chars.length; x++)
		  {
		    final char c = chars[x];
		    if ((c >= 'a') && (c <= 'z')) continue; // lowercase
		    if ((c >= 'A') && (c <= 'Z')) continue; // uppercase
		    return false;
		  }
		  return true;
	}
	
	public static boolean isAlphaNumeric(String s) 
	{
		  final char[] chars = s.toCharArray();
		  for (int x = 0; x < chars.length; x++)
		  {
		    final char c = chars[x];
		    if ((c >= 'a') && (c <= 'z')) continue; // lowercase
		    if ((c >= 'A') && (c <= 'Z')) continue; // uppercase
		    if ((c >= '0') && (c <= '9')) continue; // numeric
		    return false;
		  }
		  return true;
	}
	
	public static String[] splitStringByPattern(String input, String pattern)
	{
	        List<String> listResult = new ArrayList<String>();

	        if (!ValueTypeHelper.isEmptyValue(input))
	        {
	            String[] splits = input.split(pattern);
	            for (String word : splits)
	            {
	                if (!ValueTypeHelper.isEmptyValue(word))
	                {
	                    listResult.add(word.trim());
	                }
	            }
	        }
	        return (String[]) listResult.toArray(new String[listResult.size()]);
	}
	
	public static String[] splitAndValidateEmail(String input)
	{
		System.out.println("splitAndValidateEmail");
		
		String pattern = ";";
		
		List<String> listResult = new ArrayList<String>();

        if (!ValueTypeHelper.isEmptyValue(input))
        {
            String[] splits = input.split(pattern);
            for (String word : splits)
            {
                if (!ValueTypeHelper.isEmptyValue(word))
                {
                	if (AISDataValidateUtil.validateEmailFormat(word)) 
        			{
        				listResult.add(word.trim());
        			}
                }
            }
        }
        
        return (String[]) listResult.toArray(new String[listResult.size()]);
		
	}
	
	
	public static String insertFront(String input, String toInsert, int length)
    {
        String result = input;
        
        if (input != null)
        {
            int lengthDiff = length - input.length();
            if (lengthDiff > 0)
            {
                for (int i = 0; i < lengthDiff; i++)
                {
                    result = toInsert + result;
                }
            }
        }
        
        return result;
    }
	
	public static String generateUploadFileName(String s)
    {
		Calendar currentTime = new GregorianCalendar();
        StringBuilder prefixFile = new StringBuilder();
        prefixFile.append(currentTime.get(Calendar.YEAR));
        prefixFile.append(StringHelper.insertFront(Integer.toString((currentTime.get(Calendar.MONTH)+1)), StringHelper.ZERO, 2));
        prefixFile.append(StringHelper.insertFront(Integer.toString(currentTime.get(Calendar.DATE)), StringHelper.ZERO, 2));
        prefixFile.append(StringHelper.insertFront(Integer.toString(currentTime.get(Calendar.HOUR_OF_DAY)), StringHelper.ZERO, 2));
        prefixFile.append(StringHelper.insertFront(Integer.toString(currentTime.get(Calendar.MINUTE)), StringHelper.ZERO, 2));
        prefixFile.append(StringHelper.insertFront(Integer.toString(currentTime.get(Calendar.SECOND)), StringHelper.ZERO, 2));
        prefixFile.append("."+s);
        return prefixFile.toString();
    }
	
	public static char getStringLength(String input, int length)
    {
		if (input != null)
		{
			final char[] chars = input.toCharArray();
			for (int x = 0; x < chars.length; x++)
			{
				if(x == length)
				{
					return chars[x];
				}
			}
		}
		
		return '0';
    }

	public static String convertMS874ToTIS620(String str) throws UnsupportedEncodingException{
		return new String(str.getBytes(ENCODING_MS874), ENCODING_TIS620);
	}
}
