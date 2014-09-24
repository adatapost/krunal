<%@page import="java.util.List"%>
<%@page import="in.abc.model.Teacher"%>
<%String title="Teacher" ;%>
<%@include file="temp/header.inc"%>
<%
    List<Teacher> teachers=(List<Teacher>) request.getAttribute("teachers");
    Teacher teach=(Teacher) request.getAttribute("teacher");
    String message=(String) request.getAttribute("message");
     if(message==null)
               message="";
 
%>
<div>
<h3>Teacher</h3>
<div class="left"> 
    <form method="post" action="teacher">
        <table>
            <tr>
                <td>Teacher Id</td>
                <td>
                    <input type ="text" name="teacherId" value="<%=teach.getTeacherId()%>"/>
                    <input type ="submit" name="cmd" value="Search"/>
                </td>
            </tr>
            <tr>
                <td>Teacher Name</td>
                <td>
                    <input type ="text" name="teacherName"  value="<%=teach.getTeacherName()%>"/>
                </td>
            </tr>
            <tr>
                <td>Teacher Salary</td>
                <td>
                    <input type ="text" name="teacherSalary"  value="<%=teach.getTeacherSalary()%>"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <p class="message"><%=message%></p>
                    <input type ="submit" name="cmd" value="Add"/>
                    <input type ="submit" name="cmd" value="Update"/>
                    <input type ="submit" name="cmd" value="Delete"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<div class="left">
    <table>
        <tr>
            <th>TeacherName</th>
            <th>TeacherSalary</th>
            <th></th>
        </tr>
        <%
            for(Teacher t:teachers){
     %>
        <tr>
            <td><%=t.getTeacherName()%></td>
            <td><%=t.getTeacherSalary()%></td>
            <td>
                <form method="post" action="teacher">
                    <input type="hidden" name="teacherId" <%=t.getTeacherId()%>/>
                    <input type="submit" name="cmd" value="Edit"/>
                </form>
            </td>
          
        </tr>
       <%
        }
       %>
    </table>
</div>
    <div class="clear"></div>

</div>
        
<%@include file="temp/footer.inc"%>