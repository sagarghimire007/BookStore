package com.bookstore.dao;

import com.bookstore.entity.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDAOTest extends BaseDAOTest{
    private CategoryDAO categoryDAO;

    @BeforeEach
    void setUp() {
        BaseDAOTest.setUpBeforeClass();
        categoryDAO = new CategoryDAO(entityManager);
    }

    @Test
    void create() {
        String categoryName = "C++";
        Category category = new Category(categoryName);
        setUp();
        Category category1 = categoryDAO.create(category);
        tearDown();
        assertNotNull(category1);

    }

    @Test
    void get() {
        Integer categoryId = 14;
        setUp();
        Category category = categoryDAO.get(categoryId);
        tearDown();
        assertNotNull(category);
    }

    @Test
    void delete() {
        Integer categoryId = 23;
        setUp();
        categoryDAO.delete(categoryId);
        Category category = categoryDAO.get(categoryId);
        tearDown();
        assertNull(category);
    }

    @Test
    void listAll() {
        setUp();
        List<Category> categoryList = categoryDAO.listAll();
        if(categoryList != null){
            for(Category cat : categoryList){
                System.out.println(cat.getCategoryName());
            }
        }
        tearDown();
    }

    @Test
    void testCategoryUpdate(){
        Integer categoryId = 15;
        String categoryName = "Python";

        Category category = new Category(categoryId,categoryName);
        Category category1 = categoryDAO.update(category);
        assertNotNull(category1);
    }

    @Test
    void count() {
        setUp();
        long count = categoryDAO.count();
        tearDown();
        assertEquals(1,count);
    }

    @AfterEach
    void tearDown() {
        BaseDAOTest.tearBeforeClass();
    }
}