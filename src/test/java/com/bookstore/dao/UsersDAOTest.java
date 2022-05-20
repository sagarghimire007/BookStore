package com.bookstore.dao;

import com.bookstore.entity.Users;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class UsersDAOTest {
    private  EntityManagerFactory entityManagerFactory;
    private  EntityManager entityManager;
    private  UsersDAO userDAO;

    @Test
    void testCreateUsers() {

        Users users1 = new Users();
        users1.setEmail("punisher@gmail.com");
        users1.setFullName("Sandesh Sapkota");
        users1.setPassword("hello123");

        entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");

        entityManager = entityManagerFactory.createEntityManager();

        userDAO = new UsersDAO(entityManager);

        users1 = userDAO.create(users1);

        entityManager.close();

        entityManagerFactory.close();

        assertTrue(users1.getUserId() > 0);
    }

    @Test
    void testUpdateUsers(){

        Users user = new Users();
        user.setUserId(1);
        user.setEmail("nam@codejava.net");
        user.setFullName("Salena Gomez");
        user.setPassword("Saleena");

        entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");

        entityManager = entityManagerFactory.createEntityManager();

        userDAO = new UsersDAO(entityManager);

        user = userDAO.update(user);

        entityManager.close();

        entityManagerFactory.close();

        String expected = "Saleena";
        String actual = user.getPassword();

        assertEquals(expected,actual);
    }
}