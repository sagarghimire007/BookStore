package com.bookstore.services;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.UsersDAO;
import com.bookstore.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryServices {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private EntityManager entityManager;
    private CategoryDAO categoryDAO;


    public CategoryServices(EntityManager entityManager, HttpServletRequest request , HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.entityManager = entityManager;
        categoryDAO = new CategoryDAO(entityManager);
    }

    public void listCategory() throws ServletException, IOException {
        listCategory(null);
    }

    public void listCategory(String message) throws ServletException, IOException {
        List<Category> categoryList = categoryDAO.listAll();

        request.setAttribute("categoryList", categoryList);
        request.setAttribute("message", message);
        String categoryListPage = "category_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(categoryListPage);
        requestDispatcher.forward(request, response);
    }

    public void createCategory() throws ServletException, IOException {

        String categoryName = request.getParameter("categoryName");
        Category category = new Category(categoryName);

        if(!isCategoryNameAlreadyExist(categoryName)){
            categoryDAO.create(category);
            listCategory("Category created successfully.");
        }else {
            String message = "Category" + categoryName + " already exists.";
            request.setAttribute("message", message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    public void editCategory() throws ServletException, IOException {

        Integer categoryId = Integer.parseInt(request.getParameter("id"));
        Category category = categoryDAO.get(categoryId);
        request.setAttribute("category", category);
        String categoryEditForm = "category_form.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(categoryEditForm);
        requestDispatcher.forward(request,response);
    }

    public void updateCategory() throws ServletException, IOException {

        Integer categoryId = Integer.parseInt(request.getParameter("id"));
        String categoryName = request.getParameter("categoryName");

        Category category = new Category(categoryId, categoryName);

        if(!isCategoryNameAlreadyExist(categoryName)){
            categoryDAO.update(category);
            String message = "Category id " + categoryId + " updated successfully";
            request.setAttribute("message", message);
            listCategory(message);
        }else{
            String message  = "Could not update Category. Category " + categoryName + " already exists.";
            request.setAttribute("message", message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    public void deleteCategory() throws ServletException, IOException {
        Integer categoryId = Integer.parseInt(request.getParameter("id"));
        if(categoryId != null) {
            categoryDAO.delete(categoryId);
            String message = "Category id " + categoryId + " deleted successfully";
            listCategory(message);
        }else{
            String message = "Could not delete the Category. Please try again !";
            request.setAttribute("message" ,message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    public boolean isCategoryNameAlreadyExist(String categoryName){
        Category catName = categoryDAO.findByCategoryName(categoryName);
        if(catName != null){
            return true;
        }
        return false;
    }
}
