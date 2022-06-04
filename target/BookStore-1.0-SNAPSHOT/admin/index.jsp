
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Evergreen BookStore Administration</title>
    <link rel="stylesheet" href="../css/style.css">

</head>

<body>
<jsp:directive.include file="header.jsp" />
<div align="center">
    <h2 class="pageHeading">Administrative Dashboards</h2>
</div>

<div align="center">
    <h2 class="pageHeading">Quick Actions :</h2>
    <a href="create_book">New Book</a> |
    <a href="create_user">New User</a> |
    <a href="create_category">New Category</a> |
    <a href="create_customer">New Customer</a>
</div>

<div align="center">
    <h2 class="pageHeading">Recent Sales :</h2>
</div>


<div align="center">
    <h2 class="pageHeading">Recent Reviews :</h2>
</div>


<div align="center">
    <h2 class="pageHeading">Statistics :</h2>
</div>


<jsp:directive.include file="footer.jsp" />

</body>
</html>
