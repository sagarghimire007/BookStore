
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create New User - EverGreen Online BookStore</title>
    <link rel="stylesheet" href="../css/style.css">
    <script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>

<jsp:directive.include file="header.jsp"/>

<div align="center">
    <h2 class="pageHeading">
        <c:if test="${user == null}">
            <div align="center">
                Create New User
            </div>
        </c:if>
    </h2>
</div>

    <c:if test="${user != null}">
        <div align="center">
            <h2 class="pageHeading">Edit User</h2>
        </div>
    </c:if>

    <div align="center">
        <c:if test="${user != null}">
            <form action="update_user" method="POST" id="userForm">
                <input type="hidden" name="id" value="${user.id}">
                </c:if>

                <c:if test="${user == null}">
                    <form action="create_user" method="POST" id="userForm">
                        </c:if>
        <table class="form">
            <tr>
                <td align="right"><label for="email">Email </label></td>
                <td align="right"><input type="text" name="email" size="30" id="email" value="${user.email}"></td>
            </tr>

            <tr>
                <td align="right"><label for="fullName">Full Name </label></td>
                <td align="right"><input type="text" name="fullName" size="30" id="fullName" value="${user.fullName}"></td>
            </tr>

            <tr>
                <td align="right"><label for="password">Password </label></td>
                <td align="right"><input type="password" name="password" size="30" id="password" value="${user.password}"></td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button type="submit">Save</button>
                    <button id="cancelButton">Cancel</button>
                </td>
            </tr>
        </table>
        </form>
    </div>

<jsp:directive.include file="footer.jsp"/>
</body>

<script type="text/javascript">
    $(document).ready(function(){
        $("#userForm").validate({
            rules:{
                email: {
                    required: true,
                    email: true
                },
                fullName : "required",
                password: "required",
            },
            messages:{
                email: {
                    required: "Please enter email.",
                    email: "Please enter an valid email address"
                },
                fullName: "Please enter Full Name",
                password: "Please enter Password"
            }
        });
    });


    $("#cancelButton").click(function(){
        history.go(-1);
    });
</script>
</html>
