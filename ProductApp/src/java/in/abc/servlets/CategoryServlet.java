/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.servlets;

import in.abc.U;
import in.abc.model.Category;
import in.abc.model.CategoryDao;
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
@WebServlet(name = "CategoryServlet", urlPatterns = {"/category"})
public class CategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category cat = new Category();
        String message = "";
        String categoryId = U.get("categoryId", req); //req.getParameter("categoryId");
        String categoryName = req.getParameter("categoryName");
        String cmd  = req.getParameter("cmd");
        
        if("Add".equals(cmd)){
            cat.setCategoryId(U.toInt(categoryId));
            cat.setCategoryName(categoryName);
            if(CategoryDao.add(cat)){
                message = "Category added";
            }else{
                message = "Category not added";
            }
        } 
        else if("Search".equals(cmd) 
                || "Edit".equals(cmd)) {
             cat.setCategoryId(U.toInt(categoryId));
             Category search = CategoryDao.get(cat);
             if(search!=null){
                 cat.setCategoryName(search.getCategoryName());
             }else{
                 message = "Not found";
             }
        }
        else if("Update".equals(cmd)){
            cat.setCategoryId(U.toInt(categoryId));
            cat.setCategoryName(categoryName);
            if(CategoryDao.update(cat)){
                message = "Category updated";
            }else{
                message = "Category not updated";
            }
        }
        else if("Delete".equals(cmd)){
             cat.setCategoryId(U.toInt(categoryId));
            
            if(CategoryDao.delete(cat)){
                message = "Category deleted";
            }else{
                message = "Category not deleted";
            }
        }
          
        req.setAttribute("categories",CategoryDao.gets());
        req.setAttribute("category", cat);
        req.setAttribute("message", message);
        req.getRequestDispatcher("/category.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("categories",CategoryDao.gets());
        req.setAttribute("category", new Category());
        req.getRequestDispatcher("/category.jsp").forward(req,resp);
    }
}
