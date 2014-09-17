package in.abc; 

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author admin
 */
public class U {

    public static int toInt(Object obj) {
        try {
            return Integer.parseInt(obj.toString());
        } catch (Exception e) {
            return 0;
        }
    }
    public static Boolean toBool(Object obj) {
        try {
            return Boolean.parseBoolean(obj.toString());
        } catch (Exception e) {
            return false;
        }
    }
    public static String get(String key, HttpServletRequest req){
        return req.getParameter(key);
    }
}
