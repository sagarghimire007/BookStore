
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create New Book - EverGreen Online BookStore</title>
    <link rel="stylesheet" href="../css/style.css">
    <script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../js/jquery-ui.min.js"></script>

</head>
<body>

<jsp:directive.include file="header.jsp"/>

<div align="center">
    <h2 class="pageHeading">
        <c:if test="${user == null}">
            <div align="center">
                Create New Book
            </div>
        </c:if>
    </h2>
</div>

<c:if test="${user != null}">
    <div align="center">
        <h2 class="pageHeading">Edit Book</h2>
    </div>
</c:if>

<div align="center">
    <c:if test="${user != null}">
    <form action="update_book" method="POST" id="userForm">
        <input type="hidden" name="id" value="${user.id}">
        </c:if>

        <c:if test="${user == null}">
        <form action="create_book" method="POST" id="bookForm">
            </c:if>
            <table class="form">

                <tr>
                    <td>Category :</td>
                    <td>
                        <select name="category">
                            <c:forEach var="category" items="${categoryList}">
                                <option value="${category.id}">
                                    ${category.categoryName}
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right"><label for="title">Title : </label></td>
                    <td align="left"><input type="text" name="title" size="30" id="title" value="${book.title}"></td>
                </tr>

                <tr>
                    <td align="right"><label for="author">Author : </label></td>
                    <td align="left"><input type="text" name="author" size="30" id="author" value="${book.author}"></td>
                </tr>

                <tr>
                    <td align="right"><label for="isbn">ISBN : </label></td>
                    <td align="left"><input type="text" name="isbn" size="30" id="isbn" value="${book.isbnNumber}"></td>
                </tr>

                <tr>
                    <td align="right"><label for="publishDate">Publish Date : </label></td>
                    <td align="left"><input type="text" name="publishDate" size="30" id="publishDate" value="${book.publishDate}"></td>
                </tr>

                <tr>
                    <td align="right"><label for="bookImage">Book Image : </label></td>
                    <td align="left"><input type="file" name="bookImage" size="30" id="bookImage" value="${book.image}"></td>
                </tr>

                <tr>
                    <td align="right"><label for="price">Price : </label></td>
                    <td align="left"><input type="text" name="price" size="30" id="price" value="${book.price}"></td>
                </tr>

                <tr>
                    <td align="right"><label for="description">Description : </label></td>
                    <td align="left"><textarea rows="5" cols="50" name="description" id="description"></textarea></td>
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
        $('#publishDate').datepicker();

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
