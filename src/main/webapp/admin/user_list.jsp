
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Management - Evergreen Online BookStore</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>

<div align="center">
    <h1>Users Management</h1>
</div>

<div align="center">
    <a href="create_user">Create New User</a>
</div>

<c:if test="${message != null}">
    <div align="center">
        <h4><i>${message}</i></h4>
    </div>
</c:if>

&nbsp;&nbsp;
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Index</th>
            <th>Id</th>
            <th>Email</th>
            <th>Full Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${userList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.fullName}</td>
                <td><a href="edit_user?id=${user.id}">Edit</a> &nbsp;
                    <a href="javascript:confirmDelete(${user.id})">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:directive.include file="footer.jsp"/>


</body>

<script>
    function confirmDelete(id){
        if(confirm('Are tou sure want to delete the user with Id ' + id +' ?')){
            window.location = 'delete_user?id=' +id;
        }
    }
</script>
</html>
