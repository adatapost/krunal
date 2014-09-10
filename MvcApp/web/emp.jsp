<% String title = "Manage Emp";%>
<%@include  file="templates/header.jspf" %>
<div>
    <h1>Add New Employee Record</h1>
    <form method="post" action="emp">
        <p><label for="empNo">Employee No</label></p>
        <p><input type="text" name="empNo" id="empNo"/></p>  
        <p><label for="empName">Employee Name</label></p>
        <p><input type="text" name="empName" id="empName"/></p>
        <p><label for="joinDate">Join Date</label></p>
        <p><input type="text" name="joinDate" id="joinDate"/></p>
        <p><input type="submit" name="cmd" value="Submit"/></p>
    </form>
</div>
<%@include  file="templates/footer.jspf" %>