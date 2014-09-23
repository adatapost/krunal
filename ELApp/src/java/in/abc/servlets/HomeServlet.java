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

/**
 *
 * @author admin
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/public"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String fileName = "/home.jsp";
        String title= "Home";
        if ("About".equals(action)) {
            fileName = "/about.jsp";
            title="About us";
        }
        if ("Contact".equals(action)) {
            fileName = "/contact.jsp";
            title = "Contact us";
            request.setAttribute("address", "23-ABC Apt - Mumbai");
        }
        request.setAttribute("title", title);
        request.getRequestDispatcher(fileName)
                .forward(request, response);
    }

}
