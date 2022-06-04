package com.bookstore.dao;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDAOTest extends BaseDAOTest {

    private BookDAO bookDAO;

    @BeforeEach
    void setUp() {
        BaseDAOTest.setUpBeforeClass();
        bookDAO = new BookDAO(entityManager);
    }


    @Test
    void testCreateBook() throws ParseException, IOException {
        Book newBook = new Book();

        Category category = new Category("SQL");
        category.setId(22);
        newBook.setCategory(category);

        newBook.setTitle("Effective Java");
        newBook.setAuthor("Deepak Bajracharya");
        newBook.setDescription("This is a book of java with new features.");
        newBook.setPrice(38.87);
        newBook.setIsbnNumber("032345646");

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date publishDate = dateFormat.parse("05/28/2008");
        newBook.setPublishDate(publishDate);
        newBook.setLastUpdateTime(new Date());


        String imagePath = "C:\\sagar\\Java Book Store Project Resource\\Book Resource\\books\\Effective Java.jpg";
        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
        newBook.setImage(imageBytes);
        Book createdBook = bookDAO.create(newBook);

        assertTrue(createdBook.getId() > 0);
    }

    @Test
    public void testUpdateBook() throws ParseException, IOException {

        Book existBook = new Book();
        existBook.setId(2);

        Category category = new Category("Programming Language");
        category.setId(21);
        existBook.setCategory(category);

        existBook.setTitle("Effective Java (3rd Edition)");
        existBook.setAuthor("Balaguru Swamy");
        existBook.setDescription("This is a book of java with new features.");
        existBook.setPrice(40.00);
        existBook.setIsbnNumber("032345646");

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date publishDate = dateFormat.parse("05/28/2008");
        existBook.setPublishDate(publishDate);
        existBook.setLastUpdateTime(new Date());


        String imagePath = "C:\\sagar\\Java Book Store Project Resource\\Book Resource\\books\\Effective Java.jpg";
        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
        existBook.setImage(imageBytes);
        Book updatedBook = bookDAO.update(existBook);

        assertEquals(2, updatedBook.getId());

    }

    @Test
    void testGetBook() {
        Integer bookId = 2;
        Book book = bookDAO.get(bookId);

        assertNotNull(book);
    }

    @Test
    void testDeleteBook() {
        Integer bookId = 7;
        bookDAO.delete(bookId);
    }

    @Test
    void testBookListAll() {
        List<Book> book =  bookDAO.listAll();
        for(Book abook : book){
            System.out.println(abook.getTitle() + " - " + abook.getAuthor());
        }
        assertTrue(!book.isEmpty());
    }

    @Test
    public void testFindBookByTitle(){
        String title = "Effective Java (3rd Edition)";
        List<Book> book = bookDAO.findBookByTitle(title);

        assertNotNull(book);
    }

    @Test
    void count() {
        Long count = bookDAO.count();
        assertNotNull(count > 0);
    }

    @AfterEach
    void tearDown() {
        BaseDAOTest.tearBeforeClass();
    }
}