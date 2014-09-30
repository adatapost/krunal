/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebFilter(filterName = "FirstFilter", urlPatterns = {"*.do"})
public class FirstFilter implements Filter {
    Map<String,String> urlMap;
     
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        urlMap = new HashMap<>();
        urlMap.put("home.do", "index.jsp");
        urlMap.put("about.do", "sample.jsp");
        urlMap.put("contact.do", "my-contact.jsp");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         HttpServletRequest req = (HttpServletRequest) request;
         HttpServletResponse res = (HttpServletResponse) response;
         
         String requestUrl = req.getRequestURL().toString();
         String []array = requestUrl.split("[/]");
         int lastIndex = array.length-1;
         if(lastIndex!=-1) {
             String value = urlMap.get(array[lastIndex]);
             if(value !=null) {
                   String url =  "/"+ value;
                   req.getRequestDispatcher(url).forward(request, response);
             }else {
                 req.getRequestDispatcher("/404.jsp").forward(request, response);
             }
         }
         
    }

    @Override
    public void destroy() {
    }
   
}
