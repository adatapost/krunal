<a href="public">Home</a>
<a href="public?action=About">About us</a>
<a href="public?action=Contact">Contact us</a>

<%
    pageContext.setAttribute("now", new java.util.Date());
    pageContext.setAttribute("product", new in.abc.model.Product(10,"Pencil"));
    pageContext.setAttribute("cities", new String[] {"Meh","Pat","Raj"});
%>    
 
<br/>${10 + 20} 
<br/>${10 - 20} 
<br/>${10 * 20} 
<br/>${10 / 20} 
<br/>${10 % 20} 
<br/>${10 div 20} 
<br/>${10 mod 20} 

<br/>${10 == 20} Or ${10 eq 20}
<br/>${10 != 20} Or ${10 ne 20}
<br/>${10 > 20} Or ${10 gt 20}
<br/>${10 < 20} Or ${10 lt 20}
<br/>${10 >= 20} Or ${10 ge 20}
<br/>${10 <= 20} Or ${10 le 20}
<br/>${! true} Or ${not true}
<br/>${empty student}  
<br/>${not empty student}  

<br/>${3>2 && 3<8} or ${3>2 and 3<8}  
<br/>${3>2 || 3<8} or ${3>2 or 3<8}  
<br/>${empty student ? "Student not found" : "Found"}
