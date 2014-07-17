/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Test {

    public static void main(String[] args) {
        Date dt = D.toDate(30, 10, 2003);
        System.out.println(D.toLong(dt));
    }

    public static void main5(String[] args) {
        Date dt = D.now();
        System.out.println(D.toShort(dt));

        dt = D.toDate("d-M-y", "31-12-2002");
        System.out.println(dt);

    }

    public static void main2(String[] args) {
        System.out.println(new SimpleDateFormat("dd-MM-yyyy h:m:s a")
                .format(new Date()));
    }

    public static void main1(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy H:m:s");
        String strDate = "31-Oct-2012 18:4:3";

        Date date = null;

        try {
            date = sdf.parse(strDate);
            System.out.println(date);  //success
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
