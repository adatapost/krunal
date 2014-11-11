/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.servlets;

import in.abc.model.Dept;
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
@WebServlet(name = "DeptServlet", urlPatterns = {"/dept"})
public class DeptServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           Session sess = HbUtil.getSessionFactory().openSession();
           Transaction tran = sess.beginTransaction();
           Dept dept = new Dept();
           String message = "";
           String cmd = req.getParameter("cmd");
           dept.setDeptNo(Short.parseShort(req.getParameter("deptNo")));
           dept.setDeptName(req.getParameter("deptName"));
           
           if("Edit".equals(cmd)) {
               List<Dept> list = sess.createCriteria(Dept.class)
                                .add(Restrictions.eq("deptNo", 
                                        dept.getDeptNo())).list();
               
               if(!list.isEmpty()) {
                   req.setAttribute("dept", list.get(0));
               }
           }
           if("Update".equals(cmd)) {
               List<Dept> list = sess.createCriteria(Dept.class)
                                .add(Restrictions.eq("deptNo", 
                                        dept.getDeptNo())).list();
               try {
                   Dept search = list.get(0);
                   search.setDeptName(dept.getDeptName());
                sess.update(search);
                tran.commit();
              } catch (Exception e) {
                  tran.rollback();
              }
           }
          if("Delete".equals(cmd)) {
                List<Dept> list = sess.createCriteria(Dept.class)
                                .add(Restrictions.eq("deptNo", 
                                        dept.getDeptNo())).list();
               try {
                   Dept search = list.get(0);
                sess.delete(search);
                tran.commit();
              } catch (Exception e) {
                  tran.rollback();
              }
           }
           
           if("Add".equals(cmd)) {
               try {
                   sess.save(dept);
                   tran.commit();
                   message = "Dept added";
               } catch (Exception e) {
                   tran.rollback();
                   message = "Cannot add dept";
               }
               
           }
           
           List<Dept> depts = sess.createCriteria(Dept.class).list();
           req.setAttribute("depts", depts);
           req.setAttribute("message", message);
           req.getRequestDispatcher("/dept.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           Session sess = HbUtil.getSessionFactory().openSession();
           Transaction tran = sess.beginTransaction();
           List<Dept> depts = sess.createCriteria(Dept.class).list();
           req.setAttribute("depts", depts);
           req.getRequestDispatcher("/dept.jsp").forward(req, resp);
    }
}
