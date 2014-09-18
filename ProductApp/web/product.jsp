<%@page import="in.abc.model.Product"%>
<%@page import="in.abc.model.Category"%>
<%@page import="java.util.List"%>
<% String title = "Product"; %>
<%@include  file="templates/header.inc" %>

<%
    List<Category> categories = (List<Category>) request.getAttribute("categories");
    String[] units = {"Nog", "Dozen", "KG", "Gm", "Ltr", "Tin"};
    String message = (String) request.getAttribute("message");
    Product product = (Product) request.getAttribute("product");
    List<Product> products = (List<Product>) request.getAttribute("products");

%>
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
                            <%    for (Category cat : categories) {
                                    if (cat.getCategoryId().equals(product.getCategoryId())) {
                                        out.println("<option selected value=" + cat.getCategoryId() + ">" + cat.getCategoryName() + "</option>");
                                    } else {
                                        out.println("<option  value=" + cat.getCategoryId() + ">" + cat.getCategoryName() + "</option>");
                                    }
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Product ID</td>
                    <td>
                        <input type="text" name="productId" value="<%=product.getProductId()%>" />
                        <input type="submit" name="cmd" value="Search"/>
                    </td>
                </tr>
                <tr>
                    <td>Product Name</td>
                    <td>
                        <input type="text" name="productName" value="<%=product.getProductName()%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Unit of measurement</td>
                    <td>
                        <select name="unit">
                            <option value="">Select</option>
                            <%
                                for (String u : units) {
                                    if (u.equals(product.getUnit())) {
                                        out.println("<option selected>" + u + "</option>");
                                    } else {
                                        out.println("<option>" + u + "</option>");
                                    }
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Is Available?</td>
                    <td>
                        <input type="checkbox" <%=(product.isAvailable() ? "checked" : "")%> name="available" value="1"/>

                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <p><%=message%></p>
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
            <% 
            for(Product p: products){
                %>
                <tr>
                <td><%=p.getProductId()%></td>
                <td><%=p.getCategory().getCategoryName()%></td>
                <td><%=p.getProductName()%></td>
                <td><%=p.getUnit()%></td>
                <td><%
                   if(p.isAvailable())
                       out.println("<input type='checkbox' disabled checked/>");
                  else
                        out.println("<input type='checkbox' disabled />");
                %></td>
                <td>
                    <form method="post" action="product">
                        <input type="hidden" name="productId" value="<%=p.getProductId()%>"/>
                        <input type="submit" name="cmd" value="Edit"/>
                        <input type="submit" name="cmd" value="Delete"/>
                    </form>
                </td>
                </tr>
                <%
            }
            %>
        </table>
    </div>
</div>
<%@include  file="templates/footer.inc" %>