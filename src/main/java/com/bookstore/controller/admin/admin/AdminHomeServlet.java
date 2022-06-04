package com.bookstore.controller.admin.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminHomeServlet", value = "/admin/")
public class AdminHomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
            String adminPage = "index.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(adminPage);
            requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        doGet(request , response);
    }
}
