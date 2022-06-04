package com.bookstore.controller.admin.category;

import com.bookstore.controller.BaseServlet;
import com.bookstore.services.CategoryServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateCategoryServlet", value = "/admin/update_category")
public class UpdateCategoryServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException,
            IOException {
        CategoryServices categoryServices = new CategoryServices(entityManager, request, response);
        categoryServices.updateCategory();
    }
}
