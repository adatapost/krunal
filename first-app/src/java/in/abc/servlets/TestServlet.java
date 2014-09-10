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
@WebServlet(name = "TestServlet", urlPatterns = {"/test", "/best", "/hello/one"})
public class TestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, 
            HttpServletResponse response) 
                throws ServletException, IOException {
        response.getWriter().println("<h1>POST Method Response</h1>");
    }

    @Override
    protected void doGet(HttpServletRequest req, 
            HttpServletResponse resp) 
               throws ServletException, IOException {
         resp.getWriter().println("<h1>GET Method Response</h1>");
    }
        
}
