/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.abc.servlets;

import in.abc.model.StudentHandler;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author admin
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/student-data"})
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser sax;
        try {
            sax = factory.newSAXParser();

            File file = new File( getServletContext().getRealPath("/docs/std.xml") );

            //Create handler object
            StudentHandler handle = new StudentHandler();

            sax.parse(file, handle);
            request.setAttribute("students", handle.getList());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
