<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
     Cookie []cookies=request.getCookies();
     for(Cookie c: cookies){
         if(c.getName().equals("no")) {
             Cookie c1=new Cookie("no","");
             c1.setMaxAge(0);
             c1.setPath("/");
            response.addCookie(c1);
             
             break;
         }
     }
%>    
 
<hr/>
<a href="add-cookie.jsp">Add Data</a>
<a href='show-cookie.jsp'>Show Data</a>
<a href='delete-cookie.jsp'>Delete Data</a>

 