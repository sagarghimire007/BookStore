package com.bookstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDAOTest {
    protected static EntityManagerFactory entityManagerFactory;
    protected static EntityManager entityManager;

    public static void setUpBeforeClass(){
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void tearBeforeClass(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
