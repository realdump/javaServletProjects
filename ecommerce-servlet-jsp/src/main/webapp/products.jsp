<%@ page import="java.util.*, com.example.model.Product" %>
<html>
<head><title>Products</title></head>
<body>
<h2>Product List</h2>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    for(Product p : products) {
%>
    <p><%= p.getName() %> - $<%= p.getPrice() %> 
    <a href="cart?action=add&id=<%= p.getId() %>">Add to Cart</a></p>
<% } %>
<a href="cart">View Cart</a>
</body>
</html>