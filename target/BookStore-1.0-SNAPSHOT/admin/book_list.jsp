
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Management - Evergreen Online BookStore</title>
    <link rel="stylesheet" href="../css/style.css">

    <script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.min.js"></script>

</head>
<body>
<jsp:directive.include file="header.jsp"/>

<div align="center">
    <h2 class="pageHeading">Book Management</h2>
</div>

<div align="center">
    <h3><a href="create_book">Create New Book</a></h3>
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
            <th>Image</th>
            <th>Title</th>
            <th>Author</th>
            <th>Category</th>
            <th>Price</th>
            <th>Last Updated</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="book" items="${bookList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${book.id}</td>
                <td>
                    <img src="data:image/jpg;base64,${book.base64Image}" height="110px" width="84px"/>
                </td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.category.categoryName}</td>
                <td>${book.price}</td>
                <td>${book.lastUpdateTime}</td>
                <td><a href="edit_book?id=${book.id}">Edit</a> &nbsp;
                    <a href="javascript:void(0);" class="delete_book" id="${book.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:directive.include file="footer.jsp"/>


</body>

<script>

    $(document).ready(function(){
        $(".delete_book").each(function (){
            $(this).on("click", function (){
                id = $(this).attr("id");
                if (confirm('Are tou sure want to delete the Book with Id ' + id + ' ?')) {
                    window.location = 'delete_book?id=' +id;
                }
            });
        });
    });
</script>
</html>
