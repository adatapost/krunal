/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.servlets;

import in.abc.model.Dept;
import in.abc.model.Emp;
import in.abc.util.HbUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author admin
 */
@WebServlet(name = "EmpServlet", urlPatterns = {"/emp"})
public class EmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           Session sess = HbUtil.getSessionFactory().openSession();
           Transaction tran = sess.beginTransaction();
           Emp emp = new Emp();
           String message = "";
           String cmd = req.getParameter("cmd");
           emp.setEmpNo(Short.parseShort(req.getParameter("empNo")));
           emp.setEmpName(req.getParameter("empName"));
           
           
           if("Edit".equals(cmd)) {
               List<Emp> list = sess.createCriteria(Emp.class)
                                .add(Restrictions.eq("empNo", 
                                        emp.getEmpNo())).list();
               
               if(!list.isEmpty()) {
                   req.setAttribute("emp", list.get(0));
               }
           }
           if("Update".equals(cmd)) {
                List<Emp> list = sess.createCriteria(Emp.class)
                                .add(Restrictions.eq("empNo", 
                                        emp.getEmpNo())).list();
               try {
                   Emp search = list.get(0);
                   search.setEmpName(emp.getEmpName());
                   search.setDept(new Dept( Short.parseShort(req.getParameter("deptNo"))));
                sess.update(search);
                tran.commit();
              } catch (Exception e) {
                  tran.rollback();
              }
           }
          if("Delete".equals(cmd)) {
                List<Emp> list = sess.createCriteria(Emp.class)
                                .add(Restrictions.eq("empNo", 
                                        emp.getEmpNo())).list();
               try {
                   Emp search = list.get(0);
                sess.delete(search);
                tran.commit();
              } catch (Exception e) {
                  tran.rollback();
              }
           }
           
           if("Add".equals(cmd)) {
               try {
                   emp.setDept(new Dept( Short.parseShort(req.getParameter("deptNo"))));
                   sess.save(emp);
                   tran.commit();
                   message = "Emp added";
               } catch (Exception e) {
                   tran.rollback();
                   message = "Cannot add emp";
               }
               
           }
           
            sess = HbUtil.getSessionFactory().openSession();
            tran = sess.beginTransaction();
           List<Dept> depts = sess.createCriteria(Dept.class).list();
           req.setAttribute("depts", depts);
           req.setAttribute("message", message);
             List<Emp> emps = sess.createCriteria(Emp.class).list();
           req.setAttribute("emps", emps);
           req.getRequestDispatcher("/emp.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           Session sess = HbUtil.getSessionFactory().openSession();
           Transaction tran = sess.beginTransaction();
           List<Dept> depts = sess.createCriteria(Dept.class).list();
           req.setAttribute("depts", depts);
           
           List<Emp> emps = sess.createCriteria(Emp.class).list();
           req.setAttribute("emps", emps);
           req.getRequestDispatcher("/emp.jsp").forward(req, resp);
           
           
           
           
    }
}
