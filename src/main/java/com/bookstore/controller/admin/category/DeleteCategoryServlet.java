package com.bookstore.controller.admin.category;

import com.bookstore.controller.BaseServlet;
import com.bookstore.services.CategoryServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCategoryServlet", value = "/admin/delete_category")
public class DeleteCategoryServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException,
            IOException {
        CategoryServices categoryServices = new CategoryServices(entityManager,request ,response);
        categoryServices.deleteCategory();
    }
}
