<% String title = "Manage Emp";%>
<%@include  file="templates/header.jspf" %>
<%
    java.util.List<in.abc.model.Emp> list = (java.util.List<in.abc.model.Emp>) request.getAttribute("emps");
    in.abc.model.Emp emp = (in.abc.model.Emp) request.getAttribute("emp");
    String message = (String) request.getAttribute("message");
    if (message == null) {
        message = "";
    }
%>
<div>
    <h1>Add New Employee Record</h1>
    <form method="post" action="emp">
        <p><label for="empNo">Employee No</label></p>
        <p>
            <input type="text" name="empNo" id="empNo" value="<%=emp.getEmpNo()%>" />
            <input type="submit" name="cmd" value="Search"/>
        </p>  
        <p><label for="empName">Employee Name</label></p>
        <p><input type="text" name="empName" id="empName" value="<%=emp.getEmpName()%>"/></p>
        <p><label for="joinDate">Join Date</label></p>
        <p><input type="text" name="joinDate" id="joinDate" value="<%=emp.getJoinDate()%>"/></p>
        <p><%=message%></p>
        <p>
            <input type="submit" name="cmd" value="Add"/>
            <input type="submit" name="cmd" value="Update"/>
            <input type="submit" name="cmd" value="Delete"  onclick="return confirm('Are you sure to delete a record?');" />
        </p>
    </form>
</div>

<table>
    <tr>
        <th>No</th>
        <th>Name</th>
        <th>Date</th>
        <th></th>
    </tr>
    <%
        for (in.abc.model.Emp em : list) {
    %>
    <tr>
        <td><%=em.getEmpNo()%></td>
        <td><%=em.getEmpName()%></td>
        <td><%=em.getJoinDate()%></td>
        <td>
            <form method="post" action="emp">
                <input type="hidden" name="empNo" value="<%=em.getEmpNo()%>"/>
                <input type="submit" name="cmd" value="Select"/>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>        
<%@include  file="templates/footer.jspf" %>