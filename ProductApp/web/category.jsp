<%@page import="in.abc.model.*,java.util.List"%>
<% String title = "Category"; %>
<%@include  file="templates/header.inc" %>
<%
  List<Category> categories = (List<Category>) request.getAttribute("categories");
  Category cat = (Category)request.getAttribute("category");
  String message = (String) request.getAttribute("message");
  if(message == null) message = "";
%>

<div>
    <h3>Category</h3>
    <div class="left">
        <form method="post" action="category">
            <table>
                <tr>
                    <td>Category ID</td>
                    <td>
                        <input type="text" name="categoryId" value="<%=cat.getCategoryId()%>"/>
                        <input type="submit" name="cmd" value="Search"/>
                    </td>
                </tr>
                <tr>
                    <td>Category Name</td>
                    <td><input type="text" name="categoryName" value="<%=cat.getCategoryName()%>"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <p class="message">
                            <%=message%>
                        </p>
                        <input type="submit" name="cmd" value="Add"/>
                        <input type="submit" name="cmd" value="Update"/>
                        <input type="submit" name="cmd" value="Delete"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="left">
        <table>
            <tr>
                <th>Category Name</th>
                <th></th>
            </tr>
            <%
             for(Category c: categories){
                 %>
                 <tr>
                     <td><%=c.getCategoryName()%></td>
                     <td>
                         <form method="post" action="category">
                             <input type="hidden" name="categoryId" value="<%=c.getCategoryId()%>"/>
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

<%@include  file="templates/footer.inc" %>