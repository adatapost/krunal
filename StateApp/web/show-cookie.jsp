<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
     Cookie []cookies=request.getCookies();
     for(Cookie c: cookies){
         if(c.getName().equals("no")) {
             out.println(c.getValue());
         }
     }
%>    
 
<hr/>
<a href="add-cookie.jsp">Add Data</a>
<a href='show-cookie.jsp'>Show Data</a>
<a href='delete-cookie.jsp'>Delete Data</a>

 