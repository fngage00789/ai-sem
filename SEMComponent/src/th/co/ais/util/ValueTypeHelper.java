package th.co.ais.util;

public class ValueTypeHelper 
{
    public static boolean isEmptyValue (Object input)
    {
        boolean result = false;
        
        if (input == null)
        {
            result = true;
        }
        else if (input.getClass () == String.class)
        {
            String strInput = (String) input;
            
            if (strInput.trim ().length () == 0)
            {
                result = true;
            }
        }
        
        return result;
    }
}

