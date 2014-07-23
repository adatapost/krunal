/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbapp;

import in.adc.model.Dept;
import in.adc.model.DeptDao;

/**
 *
 * @author admin
 */
public class DbApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DeptDao dao=new DeptDao();
        for(Dept d: dao.gets()){
           // System.out.println(d.getDeptName() + " " + d.getDeptNo());
            System.out.println(d);
        }
    }
     public static void main4(String[] args) {
        Dept dept=new Dept(10);
        DeptDao dao=new DeptDao();
        dept = dao.get(dept);
        if(dept!=null){
            //delete
            dao.delete(dept);
            System.out.println("deleted");
        }
        else
            System.out.println("Not found");
    }
     public static void main3(String[] args) {
        Dept dept=new Dept(10);
        DeptDao dao=new DeptDao();
        dept = dao.get(dept);
        if(dept!=null){
            //Update
            dept.setDeptLocation("Jamnagar");
           // dept.setDeptName("HR");
            dao.update(dept);
            System.out.println("Updated");
        }
        else
            System.out.println("Not found");
    }
    public static void main2(String[] args) {
        Dept dept=new Dept(101);
        DeptDao dao=new DeptDao();
        dept = dao.get(dept);
        if(dept!=null)
           System.out.println(dept);
        else
            System.out.println("Not found");
    }
    public static void main1(String[] args) {
        Dept dept=new Dept(10, "Accounting", "Surat");
        DeptDao dao=new DeptDao();
        if(dao.add(dept)){
            System.out.println("Added");
        }else{
            System.out.println("Can't add");
        }
    }
}
