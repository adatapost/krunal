/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbapp1;

import in.abc.HbUtil;
import in.abc.model.Dept;
import in.abc.model.Emp;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author admin
 */
public class HbApp1 {
     public static void main(String[] args) {
        Session session = HbUtil.getSessionFactory().openSession();
        Transaction trans=session.beginTransaction();
        
         session.createSQLQuery("insert into dept values (?,?)")
                 .setParameter(0, 30)
                 .setParameter(1, "PQR")
                 .executeUpdate();
         trans.commit();
    }
     public static void main8(String[] args) {
        Session session = HbUtil.getSessionFactory().openSession();
        Transaction trans=session.beginTransaction();
        
        List<Object[]> depts=session.createSQLQuery("select * from dept").list();
        
        for(Object []ar: depts) {
            System.out.println(ar[0] + " " + ar[1]);
        }
    }
     public static void main6(String[] args) {
        Session session = HbUtil.getSessionFactory().openSession();
        Transaction trans=session.beginTransaction();
        
         Emp emp = new Emp();
         emp.setEmpNo((short) 5);
         emp.setEmpName("Romil ");
         emp.setDept(new Dept((short) 20));

         session.save(emp);
         trans.commit();
    }
    public static void main5(String[] args) {
        Session session = HbUtil.getSessionFactory().openSession();
        Transaction trans=session.beginTransaction();
        
        List<Dept> depts =session.createCriteria(Dept.class)
                                 .add(Restrictions.eq("deptNo", (short)10))
                .add(Restrictions.and(Restrictions.eq("deptName", "aBC")))
                                 .list();
        
        if(!depts.isEmpty()){
           for(Dept d: depts) {
               System.out.println(d.getDeptNo() + " " + d.getDeptName());
           }
        }else {
            System.out.println("Not found");
        }
    }
    public static void main4(String[] args) {
        Session session = HbUtil.getSessionFactory().openSession();
        Transaction trans=session.beginTransaction();
        
        List<Dept> depts =session.createCriteria(Dept.class)
                                 .add(Restrictions.eq("deptNo", (short)10))
                                 .list();
        
        if(!depts.isEmpty()){
            Dept d = depts.get(0);
           // d.setDeptName("ABC");
           // session.update(d);
            session.delete(d);
            trans.commit();
        }else {
            System.out.println("Not found");
        }
    }
    public static void main3(String[] args) {
        Session session = HbUtil.getSessionFactory().openSession();
        Transaction trans=session.beginTransaction();
        
        List<Dept> depts =session.createCriteria(Dept.class)
                                 .add(Restrictions.eq("deptNo", (short)10))
                                 .list();
        
        if(!depts.isEmpty()){
            Dept d = depts.get(0);
            System.out.println(d.getDeptNo() + " " + d.getDeptName());
        }else {
            System.out.println("Not found");
        }
    }
    public static void main2(String[] args) {
        Session session = HbUtil.getSessionFactory().openSession();
        Transaction trans=session.beginTransaction();
        
        List<Dept> depts =session.createCriteria(Dept.class).list();
        
        for(Dept d: depts){
            System.out.println(d.getDeptNo() + " " + d.getDeptName());
        }
    }
    public static void main1(String[] args) {
        Session session = HbUtil.getSessionFactory().openSession();
        Transaction trans=session.beginTransaction();
        
        Dept dept = new Dept();
        dept.setDeptNo((short)20);
        dept.setDeptName("HR");
        
        try {
            session.save(dept);
            trans.commit();
            System.out.println("Added");
        } catch (Exception e) {
            trans.rollback();
            System.out.println(e);
        }
    }
}
