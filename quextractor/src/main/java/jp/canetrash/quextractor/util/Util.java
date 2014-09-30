package jp.canetrash.quextractor.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.UUID;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

abstract public class Util {
   
    protected static final Log log = LogFactory.getLog(Util.class);
    private static final NumberFormat fomatter = new DecimalFormat("0.0");

    public static String escapeSql(String str) {
        return StringEscapeUtils.escapeSql(str);
    }
    
    public static String formatContentCid(String id) {
        if (id == null || id.length() == 0) {
            return null;
        }
        return "c" + formatToIntegerString(id);
    }
    
    public static String createFlowInstanceId() {
        UUID uuid = UUID.randomUUID();
        return "flow_" + uuid.toString(); 
    }    
    
    public static String formatToIntegerString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            int val = fomatter.parse(str).intValue();
            return Integer.toString(val);
        } catch (ParseException e) {
            log.warn("Can't parse str:[" + str + "]");
            throw new RuntimeException(e);
        }
    }

    public static String createToString(Object[] objects) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < objects.length; i++) {
            sb.append("[");
            if (objects[i] != null) {
                sb.append(objects[i].toString());
            } else {
               sb.append("null"); 
            }
            sb.append("]");
            if (i < objects.length -1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
