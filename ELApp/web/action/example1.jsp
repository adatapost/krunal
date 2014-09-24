<jsp:useBean id="now" scope="page" class="java.util.Date"/>

<br/>Day: <jsp:getProperty name="now" property="date"/>
<br/>Hours <jsp:getProperty name="now" property="hours"/>
<br/>EL : ${now.date}

<jsp:setProperty name="now" property="date" value="10"/>
<br/>EL : ${now.date}

<jsp:useBean id="p1" scope="page" class="in.abc.model.Product"/>
<jsp:setProperty name="p1" value="10" property="id"/>
<jsp:setProperty name="p1" value="Pen" property="name"/>
<br/>${p1.id} ${p1.name}