<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div align="center">
    <div>
        <img src="../images/BookstoreAdminLogo.png">
    </div>

    <div id="adminInfo">
            Welcome, <c:out value="${sessionScope.fullName}"/> | <a href="logout">Logout</a>
    </div>

    <div id="headerMenu">
        <div class="menuItem">
            <a href="list_user">
                <img src="../images/user.png"/>
                <h4 class="iconHeader">USERS</h4>
            </a>
        </div>

        <div class="menuItem">
            <a href="list_category">
                <img src="../images/category.png"/>
                <h4 class="iconHeader">CATEGORY</h4>
            </a>
        </div>

        <div class="menuItem">
            <a href="list_books">
                <img src="../images/book.png">
                <h4 class="iconHeader">BOOKS</h4>
            </a>
        </div>

        <div class="menuItem">
            <a href="customer">
                <img src="../images/customer.png">
                <h4 class="iconHeader">CUSTOMERS</h4>
            </a>
        </div>

        <div class="menuItem">
            <a href="review">
                <img src="../images/review.png">
                <h4 class="iconHeader">REVIEWS</h4>
            </a>
        </div>

        <div class="menuItem">
            <a href="order">
                <img src="../images/order.jpg">
                <h4 class="iconHeader">ORDERS</h4>
            </a>
        </div>
    </div>
</div>