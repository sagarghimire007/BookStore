package com.bookstore.controller.admin.category;

import com.bookstore.controller.BaseServlet;
import com.bookstore.services.CategoryServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateCategoryServlet", value = "/admin/create_category")
public class CreateCategoryServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        String createCategoryPage = "category_form.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(createCategoryPage);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException,
            IOException {
        CategoryServices categoryServices = new CategoryServices(entityManager , request, response);
        categoryServices.createCategory();
    }
}
