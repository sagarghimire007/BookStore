package com.bookstore.controller.admin.user;

import com.bookstore.controller.BaseServlet;
import com.bookstore.services.UserServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ListUserServlet", value = "/admin/list_user")
public class ListUserServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        init();
        UserServices userServices = new UserServices(entityManager, request, response);
        userServices.listUser();
        destroy();
    }
}
