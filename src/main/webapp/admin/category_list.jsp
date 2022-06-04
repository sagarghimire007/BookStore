
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Category Management - Evergreen Online BookStore</title>
    <link rel="stylesheet" href="../css/style.css">

    <script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.min.js"></script>

</head>
<body>
<jsp:directive.include file="header.jsp"/>

<div align="center">
    <h1>Category Management</h1>
</div>

<div align="center">
    <a href="create_category">Create New Category</a>
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
            <th>Category Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="category" items="${categoryList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${category.id}</td>
                <td>${category.categoryName}</td>
                <td><a href="edit_category?id=${category.id}">Edit</a> &nbsp;
                    <a href="javascript:void(0);" class="delete_category" id="${category.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:directive.include file="footer.jsp"/>


</body>

<script>

    $(document).ready(function(){
        $(".delete_category").each(function (){
            $(this).on("click", function (){
              id = $(this).attr("id");
                if (confirm('Are tou sure want to delete the Category with Id ' + id + ' ?')) {
                    window.location = 'delete_category?id=' +id;
                }
            });
        });
    });
</script>
</html>
