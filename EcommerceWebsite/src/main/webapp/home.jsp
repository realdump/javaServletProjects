<%@ page session="true" %>
<html>
<head><title>Home</title></head>
<body>
<h2>Welcome, <%= session.getAttribute("email") %></h2>
<a href="logout.jsp">Logout</a>
</body>
</html>
