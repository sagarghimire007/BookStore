
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create New User - EverGreen Online BookStore</title>
</head>
<body>

<jsp:directive.include file="header.jsp"/>

    <c:if test="${user == null}">
        <div align="center">
            <h2>Create New User</h2>
        </div>
    </c:if>

    <c:if test="${user != null}">
        <div align="center">
            <h2>Edit User</h2>
        </div>
    </c:if>

    <div align="center">
        <c:if test="${user != null}">
            <form action="update_user" method="POST" onsubmit="return validateFormInput()">
                <input type="hidden" name="id" value="${user.id}">
                </c:if>

                <c:if test="${user != null}">
                    <form action="create_user" method="POST" onsubmit="return validateFormInput()">
                        </c:if>
        <table>
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
                    <input type="submit" value="Save">
                    <input type="button" value="Cancel" onclick="javascript:history.go(-1);">
                </td>
            </tr>
        </table>
        </form>
    </div>

<jsp:directive.include file="footer.jsp"/>
</body>

<script type="text/javascript">
    function validateFormInput(){
        var fieldEmail = document.getElementById("email");
        var fieldFullName = document.getElementById("fullName");
        var fieldPassword = document.getElementById("password");

        if(fieldEmail.value.length == 0){
            alert("Email is required");
            fieldEmail.focus();
            return false;
        }

        if(fieldFullName.value.length == 0){
            alert("Full Name is required");
            fieldFullName.focus();
            return false;
        }

        if(fieldPassword.value.length == 0){
            alert("Password is required");
            fieldPassword.focus();
            return false;
        }
    }
</script>
</html>
