<jsp:useBean id="p1" scope="page" class="in.abc.model.Product">
    <jsp:setProperty name="p1" property="*"/>
 </jsp:useBean>

   <form method="post"> 
     <br/>ID:   <input type="text" name="id" value="${p1.id}"/>
     <br/>NAme:  <input type="text" name="name" value="${p1.name}"/>
     <input type="submit"/>
   </form>
  
 <br/>${p1.id}  ${p1.name}