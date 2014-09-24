<jsp:include page="data">
    <jsp:param name="action" value="categories"/>
</jsp:include>
<jsp:include page="data">
    <jsp:param name="action" value="products"/>
</jsp:include>
<jsp:include page="data">
    <jsp:param name="action" value="category"/>
    <jsp:param name="categoryId" value="3"/>
</jsp:include>
${categories}
${products}
${category[0]} ${category[1]}