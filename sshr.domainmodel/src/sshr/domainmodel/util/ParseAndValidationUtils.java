package sshr.domainmodel.util;

import java.util.*;
import java.text.*;


public final class ParseAndValidationUtils {

    // You can't instantiate me!
    private ParseAndValidationUtils() { }


    public static Object parseParameterFromString(String parValue, Class<?> clazz) {

        try {
                if (parValue == null) return null;
        
                if (!clazz.getSimpleName().equals("String")) {
                
                    if (clazz.getSimpleName().equals("Date")) {

                        SimpleDateFormat sdf = new SimpleDateFormat(SystemSettings.DEFAULT_SYSTEM_DATE_FORMAT);
                        return (Date)sdf.parse(parValue);
                    }
                }
                
                
                return parValue;

        } catch (Exception ex) {
        
                    return null;
        }
    
    }


}
