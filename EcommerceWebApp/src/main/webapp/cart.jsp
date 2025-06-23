<%@ page import="java.util.Map" %>
<%@ page import="com.ecommerce.model.Product" %>
<%@ page import="com.ecommerce.model.CartItem" %>
<%
    Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
%>

<html>
<head><title>Your Cart</title></head>
<body>
<h2>Shopping Cart</h2>

<% if (cart != null && !cart.isEmpty()) {
    for (CartItem item : cart.values()) {
        Product p = item.getProduct();
%>
    <div>
        <img src="images/<%= p.getImage() %>" width="80" height="80"/>
        <p><%= p.getName() %> - $<%= p.getPrice() %></p>
        <form action="update-cart" method="post">
            <input type="hidden" name="productId" value="<%= p.getId() %>"/>
            Quantity:
            <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1"/>
            <input type="hidden" name="action" value="update"/>
            <input type="submit" value="Update"/>
        </form>
        <form action="update-cart" method="post" style="display:inline;">
            <input type="hidden" name="productId" value="<%= p.getId() %>"/>
            <input type="hidden" name="action" value="remove"/>
            <input type="submit" value="Remove"/>
        </form>
    </div>
<%
    }
} else {
%>
    <p>Your cart is empty.</p>
<% } %>

<a href="products">Continue Shopping</a>
</body>
</html>
