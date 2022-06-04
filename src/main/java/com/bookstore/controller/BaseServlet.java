package com.bookstore.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class BaseServlet extends HttpServlet {

    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    @Override
    public void init() throws ServletException{
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void destroy(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
