/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.abc.servlets;

import in.abc.U;
import in.abc.model.Login;
import in.abc.model.LoginDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login", "/admin/login", "/manager/login", "/clerk/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie c1 = new Cookie("isLogin", "");
        Cookie c2 = new Cookie("userRole", "");
        c1.setPath("/");
        c2.setPath("/");
        c1.setMaxAge(0);
        c2.setMaxAge(0);
        response.addCookie(c1);
        response.addCookie(c2);
        request.getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Login obj = new Login();
        obj.setUserName(U.get("userName", request));
        obj.setUserPass(U.get("userPass", request));
        obj.setUserEmail(U.get("userEmail", request));
        obj.setUserRole(U.get("userRole", request));
        obj.setQuestion(U.get("question", request));
        obj.setAnswer(U.get("answer", request));
        String cmd = U.get("cmd", request);
        String rememberMe = U.get("rememberMe", request);
        String message = "";
        String fileName = "/login.jsp";

        HttpSession session = request.getSession();

        /*--- Login -----*/
        if ("Login".equals(cmd)) {
            Login search = LoginDao.getLogin(obj);
            if (search != null  && search.getUserPass().equals(obj.getUserPass())) {
                Cookie c1 = new Cookie("isLogin", search.getUserName());
                Cookie c2 = new Cookie("userRole", search.getUserRole());
                c1.setPath("/");
                c2.setPath("/");

                if ( !"".equals(rememberMe)) {
                    c1.setMaxAge(60 * 60 * 24 * 7);
                    c2.setMaxAge(60 * 60 * 24 * 7);
                }
                response.addCookie(c1);
                response.addCookie(c2);

                if (search.getUserRole().equals("admin")) {
                    fileName = "/admin/index.jsp";
                } else if (search.getUserRole().equals("manager")) {
                    fileName = "/manager/index.jsp";
                } else if (search.getUserRole().equals("clerk")) {
                    fileName = "/clerk/index.jsp";
                }
            } else {
                message = "Invalid username or password";
            }
        }
        /*---- Create User (Registration) */

        if ("Register".equals(cmd)) {
            fileName = "/register.jsp";
            obj.setUserRole("clerk");
            if (LoginDao.createUser(obj)) {
                message = "Thanks!...";
            } else {
                message = "Please verify your data. Username you've choosen is not available";
            }
        }

        /* ----- */
        request.setAttribute("message", message);
        request.getRequestDispatcher(fileName).forward(request, response);
    }
}
