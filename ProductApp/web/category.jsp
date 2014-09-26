<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Category"/>
<%@include  file="templates/header.inc" %>
<div>
    <h3>Category</h3>
    <div class="left">
        <form method="post" action="category">
            <table>
                <tr>
                    <td>Category ID</td>
                    <td>
                        <input type="text" name="categoryId" value="${category.categoryId}"/>
                        <input type="submit" name="cmd" value="Search"/>
                    </td>
                </tr>
                <tr>
                    <td>Category Name</td>
                    <td><input type="text" name="categoryName" value="${category.categoryName}"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <p class="message">
                            ${message}
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
            <c:forEach var="c" items="${categories}">
          
                 <tr>
                     <td>${c.categoryName}</td>
                     <td>
                         <form method="post" action="category">
                             <input type="hidden" name="categoryId" value="${c.categoryId}"/>
                             <input type="submit" name="cmd" value="Edit"/>
                         </form>
                     </td>
                 </tr>
            </c:forEach>
        </table>
    </div>
    <div class="clear"></div>
</div>

<%@include  file="templates/footer.inc" %>