/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.servlets;

import in.abc.U;
import in.abc.model.CategoryDao;
import in.abc.model.Product;
import in.abc.model.ProductDao;
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
@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = U.get("productId", req);
        String categoryId = U.get("categoryId", req);
        String productName = U.get("productName", req);
        String unit = U.get("unit", req);
        String available = U.get("available", req);
        String cmd = U.get("cmd", req);
        String message = "";
        
        Product product = new Product();
        
        if("Add".equals(cmd)) {
            product.setProductId(U.toInt(productId));
            product.setCategoryId(U.toInt(categoryId));
            product.setProductName(productName);
            if(available == null)
                product.setAvailable(false);
            else
                product.setAvailable(true);
            product.setUnit(unit);
            
            if(ProductDao.add(product)){
                message = "Product added.";
            }else{
                message = "Cannot add product";
            }
        }
        else if("Search".equals(cmd) 
                || "Edit".equals(cmd)){
             product.setProductId(U.toInt(productId));
             Product search = ProductDao.getProduct(product);
             if(search!=null){
                 product.setCategoryId(search.getCategoryId());
                 product.setProductName(search.getProductName());
                 product.setUnit( search.getUnit());
                 product.setAvailable(search.isAvailable());
             }else{
                 message = "Product not found";
             }
        }
        
        
        req.setAttribute("categories", CategoryDao.gets());
        req.setAttribute("message", message);
        req.setAttribute("product", product);
         req.setAttribute("products",ProductDao.getProducts());
        req.getRequestDispatcher("/product.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("categories", CategoryDao.gets());
        req.setAttribute("message", "");
        req.setAttribute("product", new Product());
        req.setAttribute("products",ProductDao.getProducts());
        req.getRequestDispatcher("/product.jsp").forward(req,resp);
    }

     

}
