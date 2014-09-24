
package in.abc.servlets;

import in.abc.U;
import in.abc.model.Teacher;
import in.abc.model.TeacherDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TeacherServlet", urlPatterns = {"/teacher"})
public class TeacherServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherId=req.getParameter("teacherId");
        String teacherName=req.getParameter("teacherName");
        String teacherSalary=req.getParameter("teacherSalary");
        String cmd=req.getParameter("cmd");
        String message="";
        Teacher teach=new Teacher();
        if("Add".equals(cmd))
        {
            teach.setTeacherId(U.toint(teacherId));
            teach.setTeacherName(teacherName);
            teach.setTeacherSalary(U.toint(teacherSalary));
            if(TeacherDao.add(teach))
            {
                message="teacher added";
            }
            else 
            {
                message="teacher not added";
            }
        }else if("Update".equals(cmd))
            {
                teach.setTeacherId(U.toint(teacherId));
                teach.setTeacherName(teacherName);
                teach.setTeacherSalary(U.toint(teacherSalary));
                if(TeacherDao.update(teach))
                {
                    message="teacher updated";
                }
                else
                {
                    message="teacher not updated";
                }
            }else if("Delete".equals(cmd))
            {
                teach.setTeacherId(U.toint(teacherId));
                if(TeacherDao.delete(teach))
                {
                    message="teacher deleted";
                    
                }
                else
                {
                    message="teacher not deleted";
                }
            }else if("Search".equals(cmd) || "Edit".equals(cmd))
            {
                teach.setTeacherId(U.toint(teacherId));
                Teacher search=TeacherDao.get(teach);
                if(search!=null)
                {
                    teach.setTeacherName(search.getTeacherName());
                    teach.setTeacherSalary(search.getTeacherSalary());
                }
                else
                {
                    message="not found";
                }
            }
    
        req.setAttribute("teachers",TeacherDao.gets() );
        req.setAttribute("teacher", teach);
        req.setAttribute("message", message);
            
        
req.getRequestDispatcher("/teacher.jsp").forward(req,resp);
        

    }
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         req.setAttribute("teachers",TeacherDao.gets() );
        req.setAttribute("teacher",  new Teacher());
        req.getRequestDispatcher("/teacher.jsp").forward(req,resp);

    }
}