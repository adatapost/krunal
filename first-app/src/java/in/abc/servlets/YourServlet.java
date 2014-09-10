/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 *
 * @author admin
 */
@WebServlet("/your")
public class YourServlet extends javax.servlet.http.HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,IOException {
        PrintWriter out = response.getWriter();
        out.println("<!doctype html>");
        out.println("<body><h1>Sample Page</h1></body>");
        out.println("<br/>Date : " + new java.util.Date() );
    }
}
