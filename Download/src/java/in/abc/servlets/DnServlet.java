/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.abc.servlets;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
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
@WebServlet(name = "DnServlet", urlPatterns = {"/dn"})
public class DnServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileName =  request.getParameter("file");
        String contentType = request.getServletContext().getMimeType(fileName);
        String realPath = request.getServletContext().getRealPath("/files/" + fileName);

        //Set MIME Type
        response.setContentType(contentType);
        response.setHeader("content-disposition", "attachment; filename=" + fileName);
        response.setHeader("content-length", String.valueOf(new File(realPath).length()));
        //Read the file content and push it to the output stream
        byte[] buffer = new byte[1024];
        int length;
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(realPath))) {
            while ((length = in.read(buffer)) > 0) {
                response.getOutputStream().write(buffer, 0, length);
            }
            response.getOutputStream().flush();
        } catch (Exception ex) {
            System.out.println("Error while reading " + fileName + " : " + ex);
        }
    }
}
