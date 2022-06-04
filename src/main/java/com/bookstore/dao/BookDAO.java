package com.bookstore.dao;

import com.bookstore.entity.Book;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book>{

    public BookDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Book create(Book book){
        return super.create(book);
    }

    @Override
    public Book update(Book book){
        return super.update(book);
    }

    @Override
    public Book get(Object bookId) {
        return super.find(Book.class, bookId);
    }

    @Override
    public void delete(Object bookId) {
        super.delete(Book.class, bookId);
    }

    @Override
    public List<Book> listAll() {
        return super.findWithNamedQuery("Books.findAll");
    }

    public List<Book> findBookByTitle(String title){
        return super.findWithNamedQuery("Books.findByTitle", "title", title);
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Books.countBooks");
    }
}
