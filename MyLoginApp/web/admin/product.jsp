<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Manage Products"/>
<%@include  file="templates/header.jspf" %>
<h3>Product</h3>
<div>
    <div class="left">
        <form method="post" action="product">
            <table>
                <tr>
                    <td>Category</td>
                    <td>
                        <select name="categoryId">
                            <option value="0">Select</option>
                            <c:forEach var="cat" items="${categories}">
                                <c:choose>
                                    <c:when test="${cat.categoryId eq product.categoryId}">
                                        <option value="${cat.categoryId}" selected>${cat.categoryName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${cat.categoryId}">${cat.categoryName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Product ID</td>
                    <td>
                        <input type="text" name="productId" value="${product.productId}" />
                        <input type="submit" name="cmd" value="Search"/>
                    </td>
                </tr>
                <tr>
                    <td>Product Name</td>
                    <td>
                        <input type="text" name="productName" value="${product.productName}"/>
                    </td>
                </tr>
                <tr>
                    <td>Unit of measurement</td>
                    <td>
                        <select name="unit">
                            <option value="">Select</option>
                            <c:forEach var="u" items="Nog,Kg,Ltr,Dozen,Gm">
                                <c:choose>
                                    <c:when test="${u eq product.unit}">
                                        <option selected>${u}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>${u}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Is Available?</td>
                    <td>
                        <input type="checkbox" ${product.available ? "checked" : ""}  name="available" value="1"/>

                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <p>${message}</p>
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
                <th>Product ID</th>
                <th>Category ID</th>
                <th>Name</th>
                <th>Unit</th>
                <th>Available?</th>
                <th></th>
            </tr>
            <c:forEach var="p" items="${products}">
                <tr>
                <td>${p.productId}</td>
                <td>${p.getCategory().categoryName}</td>
                <td>${p.productName}</td>
                <td>${p.unit}</td>
                <td>
                    <c:choose>
                        <c:when test="${p.available}">
                            <input type='checkbox' disabled checked/>
                        </c:when>
                        <c:otherwise>
                            <input type='checkbox' disabled />
                        </c:otherwise>
                    </c:choose>
                   </td>
                <td>
                    <form method="post" action="product">
                        <input type="hidden" name="productId" value="${p.productId}"/>
                        <input type="submit" name="cmd" value="Edit"/>
                        <input type="submit" name="cmd" value="Delete"/>
                    </form>
                </td>
                </tr>
              </c:forEach>
        </table>
    </div>
</div>
<%@include  file="templates/footer.jspf" %>