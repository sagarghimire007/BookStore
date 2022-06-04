package com.bookstore.controller.admin.admin;

import com.bookstore.controller.BaseServlet;
import com.bookstore.services.UserServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/admin/login")
public class AdminLoginServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        UserServices userServices = new UserServices(entityManager, request, response);
        userServices.login();
    }
}
