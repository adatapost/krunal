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

    public static void main(String[] args) {
        //1. Load driver
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception ex) {
            System.out.println("Unable to load driver :" + ex);
            return;
        }

        //2. Obtain connection
        try (Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "dhavan", "dhavan")) {

            //3. Execute statements
            String sql = "select * from dept where deptno=?";
            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setInt(1, 2);
                ResultSet rs = ps.executeQuery();
               if(rs.next()){
                   System.out.println(rs.getInt("deptno") + " " + rs.getString(2) + " " + rs.getString(3));
               }else{
                   System.out.println("Dept not found");
               }
            } catch (Exception ex) {
                System.out.println("Error while executing statement " + ex);
            }

        } catch (Exception ex) {
            System.out.println("Connection error : " + ex);
        }
    }
    public static void main4(String[] args) {
        //1. Load driver
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception ex) {
            System.out.println("Unable to load driver :" + ex);
            return;
        }

        //2. Obtain connection
        try (Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "dhavan", "dhavan")) {

            //3. Execute statements
            String sql = "select * from dept";
            try (PreparedStatement ps = cn.prepareStatement(sql)) {
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
                   System.out.println(rs.getInt("deptno") + " " + rs.getString(2) + " " + rs.getString(3));
               }
            } catch (Exception ex) {
                System.out.println("Error while executing statement " + ex);
            }

        } catch (Exception ex) {
            System.out.println("Connection error : " + ex);
        }
    }
    
     public static void main3(String[] args) {
        //1. Load driver
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception ex) {
            System.out.println("Unable to load driver :" + ex);
            return;
        }

        //2. Obtain connection
        try (Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "dhavan", "dhavan")) {

            //3. Execute statements
            String sql = "delete from dept  where deptno=?";
            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setInt(1,1);
                int ret = ps.executeUpdate();
                System.out.println(ret + " row deleted");
            } catch (Exception ex) {
                System.out.println("Error while executing statement " + ex);
            }

        } catch (Exception ex) {
            System.out.println("Connection error : " + ex);
        }
    }
     public static void main2(String[] args) {
        //1. Load driver
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception ex) {
            System.out.println("Unable to load driver :" + ex);
            return;
        }

        //2. Obtain connection
        try (Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "dhavan", "dhavan")) {

            //3. Execute statements
            String sql = "update dept set deptname=?,deptlocation=? where deptno=?";
            try (PreparedStatement ps = cn.prepareStatement(sql)) {
               
                ps.setString(1, "Abc");
                ps.setString(2, "Pat");
                ps.setInt(3,1);
                int ret = ps.executeUpdate();
                System.out.println(ret + " row updated");
            } catch (Exception ex) {
                System.out.println("Error while executing statement " + ex);
            }

        } catch (Exception ex) {
            System.out.println("Connection error : " + ex);
        }
    }
    public static void main1(String[] args) {
        //1. Load driver
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception ex) {
            System.out.println("Unable to load driver :" + ex);
            return;
        }

        //2. Obtain connection
        try (Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "dhavan", "dhavan")) {

            //3. Execute statements
            String sql = "insert into dept values (?,?,?)";
            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setInt(1, 3);
                ps.setString(2, "Production");
                ps.setString(3, "Ahmedabad");
                int ret = ps.executeUpdate();
                System.out.println(ret + " row added");
            } catch (Exception ex) {
                System.out.println("Error while executing statement " + ex);
            }

        } catch (Exception ex) {
            System.out.println("Connection error : " + ex);
        }
    }
}
