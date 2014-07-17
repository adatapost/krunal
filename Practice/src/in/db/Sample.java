/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.db;

import java.sql.*;

/**
 *
 * @author admin
 */
public class Sample {
    public static void main(String []args){
        //1. Load driver
        try{
            Class.forName("oracle.jdbc.OracleDriver");
        }catch(Exception ex){
            System.out.println("Unable to load driver :" + ex) ;
            return;
        }
        
        //2. Obtain connection
        try(Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "dhavan", "dhavan")){
            System.out.println("Connection OK!");
            //3. Execute statements....s
        }catch(Exception ex){
            System.out.println("Connection error : " + ex);
        }
    }
}
