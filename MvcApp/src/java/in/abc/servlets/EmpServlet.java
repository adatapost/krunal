/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.abc.servlets;

import in.abc.model.Emp;
import in.abc.model.EmpDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "EmpServlet", urlPatterns = {"/emp"})
public class EmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Receive data.
        String empNo = request.getParameter("empNo");
        String empName = request.getParameter("empName");
        String joinDate = request.getParameter("joinDate");
        String cmd = request.getParameter("cmd");

        if (cmd == null) {
            cmd = ""; //remove null;
        }
        if ("Submit".equals(cmd)) {
            Emp emp = new Emp();
            emp.setEmpNo(Integer.parseInt(empNo));
            emp.setEmpName(empName);
            emp.setJoinDate(java.sql.Date.valueOf(joinDate));
            if (EmpDao.add(emp)) {
                System.out.println("Emp added");
            } else {
                System.out.println("Cannot add emp");
            }
            /*
             try(Db x=new Db("insert into emp values (?,?,?)")){
             x.getSt().setInt(1, Integer.parseInt(empNo));
             x.getSt().setString(2,empName);
             x.getSt().setDate(3, java.sql.Date.valueOf(joinDate)); // yyyy-mm-dd
             x.execute();
             System.out.println("Added");
             }catch(Exception ex){
             System.out.println("Error: " + ex);
             }
             */
        }

        request.getRequestDispatcher("/emp.jsp")
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/emp.jsp")
                .forward(request, response);
    }

}
