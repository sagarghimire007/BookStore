
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<jsp:directive.include file="header.jsp"/>

<h2 align="center">Please Login</h2>
<form>
    <div align="center">
        <label for="email">Email : </label>
        <input type="text" id="email" size="10">
    </div>

    <div align="center">
        <label for="fullName">Full Name : </label>
        <input type="text" id="fullName" size="10">
    </div>

    <div align="center">
        <label for="password">Password : </label>
        <input type="text" id="password" size="10">
    </div>

    <div align="center">
        <input type="submit" value="Login">
        <input type="reset" value="Cancel">
    </div>
</form>

<jsp:directive.include file="footer.jsp"/>
</body>
</html>
