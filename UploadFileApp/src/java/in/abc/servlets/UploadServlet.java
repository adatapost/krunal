/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.servlets;

import in.abc.Db;
import in.abc.U;
import in.abc.model.Emp;
import in.abc.model.EmpDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author admin
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/upload"})
@MultipartConfig()
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(Db x= new Db("select * from emp")){
            request.setAttribute("emps",x.rows());
        }catch(Exception ex) {}
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Part part = request.getPart("file");
        Emp emp=new Emp();
        emp.setEmpNo(U.toint(request.getParameter("empNo")));
        emp.setEmpName(request.getParameter("empName"));
        String message = "";
        if (part != null) {
            String ct = part.getContentType();
            long size = part.getSize();
            if(ct.equals("image/jpeg") 
                    || ct.equals("image/gif")
                        || ct.equals("image/png")) {
                if(size>=1 && size<=1024 *1024 * 2) { //  2 MB
                    emp.setPhoto(part.getSubmittedFileName());
                    if(EmpDao.addEmp(emp)){
                part.write("C:\\javaprg\\89\\UploadFileApp\\web\\files\\" + part.getSubmittedFileName());
                message = "Image file uploaded successfully.";
                    }else{
                        message = "Error";
                    }
                }else {
                    message = "File length must be below 2 MB";
                }
            } else {
                message = "Please select image file - .jpg, .gif or .png";
            }
        }

        request.setAttribute("message",message);
         try(Db x= new Db("select * from emp")){
            request.setAttribute("emps",x.rows());
        }catch(Exception ex) {}
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
