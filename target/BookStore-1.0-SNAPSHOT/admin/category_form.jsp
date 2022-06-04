
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Category - EverGreen Online BookStore</title>
    <link rel="stylesheet" href="../css/style.css">

    <script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.min.js"></script>

</head>
<body>

<jsp:directive.include file="header.jsp"/>

<c:if test="${category == null}">
    <div align="center">
        <h2 class="pageHeading">Create New Category</h2>
    </div>
</c:if>

<c:if test="${category != null}">
    <div align="center">
        <h2 class="pageHeading">Edit Category</h2>
    </div>
</c:if>

<div align="center">
    <c:if test="${category != null}">
    <form action="update_category" method="POST" id="categoryForm">
        <input type="hidden" name="id" value="${category.id}">
        </c:if>

        <c:if test="${category == null}">
        <form action="create_category" method="POST" id="categoryForm">
            </c:if>
            <table class="form">
                <tr>
                    <td align="right"><label for="categoryName">Category Name : </label></td>
                    <td align="right"><input type="text" name="categoryName" size="30" id="categoryName" value="${category.categoryName}"></td>
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
        $("#categoryForm").validate({
            rules:{
                categoryName: "required",
                },
            messages: {
                    categoryName: "Please enter category name.",
            }
        });
    });


    $("#cancelButton").click(function(){
        history.go(-1);
    })

</script>
</html>
