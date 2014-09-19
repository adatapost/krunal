<%
    pageContext.setAttribute("now", new java.util.Date());
    pageContext.setAttribute("product", new in.abc.model.Product(10,"Pencil"));
    pageContext.setAttribute("cities", new String[] {"Meh","Pat","Raj"});
%>    
 
<br/>${now}
<br/>${now.date}
<br/>${now["date"]}
<br/>${now.minutes}
<br/>${product.id}
<br/>${product.name}
<br/>${product["name"]}
<br/>${product}
<br/>Array
<br/>${cities[0]} 
<br/>${cities[1]}

