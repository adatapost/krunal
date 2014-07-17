/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author admin
 */
public class D {

    public static java.util.Date now() {
        return new Date();
    }

    public static String toShort(Date dt) {
        return new SimpleDateFormat("dd-MM-yyyy").format(dt);
    }

    public static String toLong(Date dt) {
        return new SimpleDateFormat("dd-MM-yyyy h:m:s a").format(dt);
    }

    public static Date toDate(String pattern, String str) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(str);

        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static Date toDate(int d) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, d);
        return cal.getTime();
    }

    public static Date toDate(int d, int m) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, d);
        cal.set(Calendar.MONTH, m - 1);
        return cal.getTime();
    }

    public static Date toDate(int d, int m, int y) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, d);
        cal.set(Calendar.MONTH, m - 1);
        cal.set(Calendar.YEAR, y);
        return cal.getTime();
    }

    public static Date toDate(int d, int m, int y, int h) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, d);
        cal.set(Calendar.MONTH, m - 1);
        cal.set(Calendar.YEAR, y);
        cal.set(Calendar.HOUR, h);
        return cal.getTime();
    }

    public static Date toDate(int d, int m, int y, int h, int min) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, d);
        cal.set(Calendar.MONTH, m - 1);
        cal.set(Calendar.YEAR, y);
        cal.set(Calendar.HOUR, h);
        cal.set(Calendar.MINUTE, min);
        return cal.getTime();
    }

    public static Date toDate(int d, int m, int y, int h, int min, int s) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, d);
        cal.set(Calendar.MONTH, m - 1);
        cal.set(Calendar.YEAR, y);
        cal.set(Calendar.HOUR, h);
        cal.set(Calendar.MINUTE, min);
        cal.set(Calendar.SECOND, s);
        return cal.getTime();
    }
}
