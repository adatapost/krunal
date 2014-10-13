/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.abc.servlets;

import in.abc.model.BccHandler;
import java.io.IOException;
import java.net.URL;
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
@WebServlet(name = "BbcServlet", urlPatterns = {"/bbc"})
public class BbcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        java.net.URL url = new URL("http://feeds.bbci.co.uk/news/rss.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser sax;
        try {
            sax = factory.newSAXParser();

            //Create handler object
            BccHandler handle = new BccHandler();

            sax.parse(url.openStream(), handle);
            request.setAttribute("news", handle.getList());
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

}
