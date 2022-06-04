package com.bookstore.services;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServices {

    private EntityManager entityManager;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private BookDAO bookDAO;
    private CategoryDAO categoryDAO;

    public BookServices(EntityManager entityManager , HttpServletRequest request , HttpServletResponse response){
        this.entityManager = entityManager;
        this.request = request;
        this.response = response;
        bookDAO = new BookDAO(entityManager);
        this.categoryDAO = new CategoryDAO(entityManager);
    }

    public void listBooks() throws ServletException, IOException {
        List<Book> booksList = bookDAO.listAll();
        String listBookPage = "book_list.jsp";

        request.setAttribute("bookList", booksList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listBookPage);
        requestDispatcher.forward(request ,response);

    }

    public void showBookNewForm() throws ServletException, IOException {
        List<Category> categoryList = categoryDAO.listAll();
        request.setAttribute("categoryList", categoryList);
        String newPage = "book_form.jsp";

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(newPage);
        requestDispatcher.forward(request ,response);
    }
}
