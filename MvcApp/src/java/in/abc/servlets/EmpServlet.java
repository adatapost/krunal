/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.abc.servlets;

import in.abc.U;
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
        //Receive Data
        String empNo = request.getParameter("empNo");
        String empName = request.getParameter("empName");
        String joinDate = request.getParameter("joinDate");
        String cmd = request.getParameter("cmd");
        String message = "";
        
        Emp emp = new Emp();
        //emp.setEmpNo(Integer.parseInt(empNo));
        emp.setEmpNo(U.toInt(empNo));
        if ("Add".equals(cmd)) {
            emp.setEmpName(empName);
            emp.setJoinDate(java.sql.Date.valueOf(joinDate));
            if (EmpDao.add(emp)) {
                message = "Empoyee added successfully";
            } else {
                message = "Cannot add employee";
            }
        } else if ("Search".equals(cmd) || "Select".equals(cmd)) {
            Emp search = EmpDao.get(emp);
            if (search != null) {
                emp.setEmpName(search.getEmpName());
                emp.setJoinDate(search.getJoinDate());
            } else {
                message = "Record not found.";
            }
        } else if ("Update".equals(cmd)) {
            emp.setEmpName(empName);
            emp.setJoinDate(java.sql.Date.valueOf(joinDate));
            if (EmpDao.update(emp)) {
                message = "Empoyee updated successfully";
            } else {
                message = "Cannot update employee";
            }
        } else if ("Delete".equals(cmd)) {
            if (EmpDao.delete(emp)) {
                message = "Empoyee deleted successfully";
            } else {
                message = "Cannot delete employee";
            }
        }

        //Push list of Emp into request scope
        request.setAttribute("emps", EmpDao.gets());
        request.setAttribute("emp", emp);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/emp.jsp")
                .forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Push list of Emp into request scope
        request.setAttribute("emps", EmpDao.gets());
        request.setAttribute("emp", new Emp());
        request.getRequestDispatcher("/emp.jsp")
                .forward(request, response);
    }
}
