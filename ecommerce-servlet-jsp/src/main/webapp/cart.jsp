<%@ page import="java.util.*, com.example.model.Product" %>
<html>
<head><title>Cart</title></head>
<body>
<h2>Your Cart</h2>
<%
    List<Product> cart = (List<Product>) request.getAttribute("cart");
    if(cart != null) {
        for(Product p : cart) {
%>
    <p><%= p.getName() %> - $<%= p.getPrice() %></p>
<% }} %>
<a href="products">Continue Shopping</a>
</body>
</html>