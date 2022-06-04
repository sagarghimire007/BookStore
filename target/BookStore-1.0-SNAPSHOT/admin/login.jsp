
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Admin Login</title>

    <link rel="stylesheet" href="../css/style.css">
    <script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.min.js"></script>

</head>
<body>

<div align="center">
    <h2 class="mainHeading">BookStore Administration</h2>
    <h3 id="adminSubHeading">Admin Login</h3>

    <div align="center">
        <h3>${message}</h3>
    </div>
    <form action="login" id="loginForm" method="POST">
        <table class="form">
            <tr>
                <td align="right">Email :</td>
                <td align="left"><input type="text" name="email" id="email" size="20px"></td>
            </tr>

            <tr>
                <td align="right">Password :</td>
                <td align="left"><input type="password" name="password" id="password" size="20px"></td>
            </tr>

            <tr>
                <td colspan="2" align="center"><button type="submit">Login</button></td>
            </tr>
        </table>
    </form>
</div>
</body>

<script type="text/javascript">
    $(document).ready(function(){
        $("#loginForm").validate({
            rules:{
                email: {
                    required: true,
                    email: true
                },
                password: "required",
            },
            messages:{
                email: {
                    required: "Please enter email.",
                    email: "Please enter an valid email address"
                },
                password: "Please enter Password"
            }
        });
    });

</script>
</html>
