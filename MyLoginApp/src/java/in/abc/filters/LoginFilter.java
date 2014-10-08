/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.filters;

import in.abc.model.Login;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/admin/*","/clerk/*","/manager/*"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         HttpServletRequest req = (HttpServletRequest) request;
         HttpServletResponse res = (HttpServletResponse) response;
         
         Cookie cookies[] = req.getCookies();
         String key = null, role = null;
         for(Cookie c: cookies) {
             if(c.getName().equals("isLogin")) {
                 key = c.getValue();
             }
             if(c.getName().equals("userRole")) {
                 role = c.getValue();
             }
         }
         
         String uri = req.getRequestURI();
         if( key!=null && !"".equals(key) ){
              if("admin".equals(role) && uri.contains("admin")) {
                  chain.doFilter(request, response);
              }
              else
              if("manager".equals(role) && uri.contains("manager")){
                  chain.doFilter(request, response);
              }
              else
               if("clerk".equals(role) && uri.contains("clerk")){
                   chain.doFilter(request, response);
               }
               else {
                   req.getRequestDispatcher("/login").forward(request, response);
               }
              
         }else {
             res.sendRedirect("/MyCLoginApp/login.jsp");
         }
         
    }

    @Override
    public void destroy() {
        
    }
    
    
    
}
