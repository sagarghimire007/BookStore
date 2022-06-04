package com.bookstore.dao;

import com.bookstore.entity.Users;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersDAOTest extends BaseDAOTest {
    private static UsersDAO userDAO;

    @BeforeClass
    public static void setUpBeforeClass(){
        BaseDAOTest.setUpBeforeClass();
        userDAO = new UsersDAO(entityManager);
    }

    @Test
    void testCreateUsers() {

        Users users1 = new Users();
        users1.setEmail("john@gmail.com");
        users1.setFullName("John Smith");
        users1.setPassword("johnny");

        setUpBeforeClass();
        users1 = userDAO.create(users1);
        tearDownClass();

        assertTrue(users1.getId() > 0);
    }

    @Test
    void testUpdateUsers(){

        Users user = new Users();
        user.setId(6);
        user.setEmail("john@codejava.net");
        user.setFullName("John Ronaldo");
        user.setPassword("Ronaldo");

        setUpBeforeClass();
        user = userDAO.update(user);
        tearDownClass();

        String expected = "Ronaldo";
        String actual = user.getPassword();

        assertEquals(expected,actual);
    }

    @Test
    public void testDeleteUser(){
        Integer id = 2;
        setUpBeforeClass();
        userDAO.delete(id);

        Users user = userDAO.get(id);
        assertNull(user);
    }

    @Test
    public void testListAll(){
        setUpBeforeClass();
        List<Users> userList = userDAO.listAll();
        tearDownClass();

        assertNotNull(userList);

    }

    @Test
    public void testUserCount(){
        setUpBeforeClass();
        long count = userDAO.count();
        tearDownClass();
        assertEquals(2,count);
    }

    @Test
    public void testFindByEmail(){
        String email = "rosni@gmail.com";
        setUpBeforeClass();
        Users user = userDAO.findByEmail(email);
        tearDownClass();
        assertNotNull(user);

    }

    @Test
    public void testCheckLoginSuccess(){
        setUpBeforeClass();
        String email = "sagar@gmail.com";
        String password = "1234";
        boolean result = userDAO.checkLogin(email, password);

        assertTrue(result);
    }


    @AfterClass
    public static void tearDownClass(){
        BaseDAOTest.tearBeforeClass();
    }
}