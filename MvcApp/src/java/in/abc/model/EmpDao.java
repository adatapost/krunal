/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.abc.model;

import in.abc.Db;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class EmpDao {
    /* Add Employee */

    public static boolean add(Emp emp) {
        try (Db x = new Db("insert into emp values (?,?,?)")) {
            x.getSt().setInt(1, emp.getEmpNo());
            x.getSt().setString(2, emp.getEmpName());
            x.getSt().setDate(3, emp.getJoinDate());
            x.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("EmpDao#Add :" + ex);
            return false;
        }
    }
    /* Update Employee */

    public static boolean update(Emp emp) {
        try (Db x = new Db("update  emp set emp_name=?,join_date =? where emp_no=? ")) {

            x.getSt().setString(1, emp.getEmpName());
            x.getSt().setDate(2, emp.getJoinDate());
            x.getSt().setInt(3, emp.getEmpNo());
            x.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("EmpDao#Update :" + ex);
            return false;
        }
    }

    /* Delete Employee */
    public static boolean delete(Emp emp) {
        try (Db x = new Db("delete from   emp where emp_no=? ")) {
            x.getSt().setInt(1, emp.getEmpNo());
            x.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("EmpDao#Delete :" + ex);
            return false;
        }
    }

    /* Get Employee */
    public static Emp get(Emp emp) {
        try (Db x = new Db("select * from  emp  where emp_no=? ")) {
            x.getSt().setInt(1, emp.getEmpNo());
            Object[] ar = x.row();
            if (ar != null) {
                Emp search = new Emp();
                search.setEmpNo(Integer.parseInt(ar[0].toString()));
                search.setEmpName(ar[1].toString());
                search.setJoinDate((java.sql.Date) ar[2]);
                return search;
            }

        } catch (Exception ex) {
            System.out.println("EmpDao#Get :" + ex);

        }
        return null;
    }

    /* Get Employees */
    public static List<Emp> gets() {
        List<Emp> list = new ArrayList<Emp>();
        try (Db x = new Db("select * from  emp ")) {
            for (Object[] ar : x.rows()) {
                Emp search = new Emp();
                search.setEmpNo(Integer.parseInt(ar[0].toString()));
                search.setEmpName(ar[1].toString());
                search.setJoinDate((java.sql.Date) ar[2]);
                list.add(search);
            }

        } catch (Exception ex) {
            System.out.println("EmpDao#Gets :" + ex);

        }
        return list;
    }
}
