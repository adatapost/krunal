/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.model;

import in.abc.Db;

/**
 *
 * @author admin
 */
public class EmpDao {
   public static boolean addEmp(Emp emp) {
       try(Db x=new Db("insert into emp values (?,?,?)")) {
           x.getSt().setInt(1,emp.getEmpNo());
           x.getSt().setString(2,emp.getEmpName());
           x.getSt().setString(3,emp.getPhoto());
           x.execute();
           return true;
           
       }catch(Exception ex) {
           System.out.println("EmpDao#addEmp " + ex);
       }
       return false;
   }
}
