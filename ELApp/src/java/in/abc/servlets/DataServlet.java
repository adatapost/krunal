/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.servlets;

import in.abc.Db;
import in.abc.U;
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
@WebServlet(name = "DataServlet", urlPatterns = {"/data", "/action/data"})
public class DataServlet extends HttpServlet {
    protected void executeIt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if("categories".equals(action)){
            try(Db x=new Db("select * from category")){
                request.setAttribute(action, x.rows());
            }catch(Exception ex){
                System.err.println(ex);
            }
        }
         if("category".equals(action)){
            try(Db x=new Db("select * from category where category_id=?")){
                String categoryId = request.getParameter("categoryId");
                
                x.getSt().setInt(1, U.toint(categoryId));
               request.setAttribute(action, x.row());
                
            }catch(Exception ex){
                System.err.println(ex);
            }
        }
        if("products".equals(action)){
            try(Db x=new Db("select * from product")){
                request.setAttribute(action, x.rows());
            }catch(Exception ex){
                System.err.println(ex);
            }
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executeIt(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executeIt(request, response);
    }

    

}
