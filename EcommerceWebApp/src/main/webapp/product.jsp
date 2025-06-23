<%@ page import="java.util.List" %>
<%@ page import="com.ecommerce.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Products</title></head>
<body>
<h2>Products</h2>
<% List<Product> products = (List<Product>) request.getAttribute("products"); %>
<% for (Product p : products) { %>
    <div>
        <img src="images/<%= p.getImage() %>" width="100" height="100"/>
        <p><%= p.getName() %> - $<%= p.getPrice() %></p>
    </div>
    <form action="add-to-cart" method="post">
    <input type="hidden" name="productId" value="<%= p.getId() %>"/>
    <input type="submit" value="Add to Cart"/>
</form>
    
<% } %>

</body>
</html>