/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login","/admin/login","/clerk/login","/manager/login"})
public class LoginServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Logout
        HttpSession session =request.getSession();
        session.removeAttribute("isLogin");
        session.removeAttribute("role");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
          HttpSession session =request.getSession();
        if("a".equals(username) && "a".equals(password)) {
            session.setAttribute("isLogin", username);
            session.setAttribute("role", "admin");
            request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
            return;
        }
        if("b".equals(username) && "b".equals(password)) {
            session.setAttribute("isLogin", username);
            session.setAttribute("role", "manager");
            request.getRequestDispatcher("/manager/index.jsp").forward(request, response);
            return;
        }
        if("c".equals(username) && "c".equals(password)) {
            session.setAttribute("isLogin", username);
            session.setAttribute("role", "clerk");
            request.getRequestDispatcher("/clerk/index.jsp").forward(request, response);
            return;
        }
        request.setAttribute("message", "Invalid user name of password");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    
}
