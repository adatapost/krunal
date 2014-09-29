<%-- 
    Document   : index
    Created on : Sep 29, 2014, 8:07:19 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <audio autoplay="autoplay" controls="controls">
            <source src="media?file=science.mp3"/>
        </audio>
      <video autoplay="autoplay" controls="controls">
            <source src="media?file=sample.wmv"/>
        </video>
        <img src="media?file=6.jpg"/>
        <img src="media?file=7.jpg"/>
        
        <a href="dn?file=test.pdf">Download PDF</a>
        <a href="dn?file=6.jpg">Download Image file</a>
        <a href="dn?file=sample.wmv">Download Video</a>
    </body>
</html>
