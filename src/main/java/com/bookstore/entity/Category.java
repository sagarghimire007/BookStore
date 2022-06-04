package com.bookstore.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "select c from Category c order by c.categoryName"),
        @NamedQuery(name = "Category.countCategory", query = "select count(*) from Category c"),
        @NamedQuery(name = "Category.findByCategoryName", query = "select c from Category c where c.categoryName =: categoryName")
})

@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Integer id;

    @Column(name = "category_name", nullable = false, length = 30)
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private Set<Book> books = new LinkedHashSet<>();

    // non-parameterized constructor
    public Category() {
    }

    // parameterized constructor
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(Integer categoryId , String categoryName) {
        this.id = categoryId;
        this.categoryName = categoryName;
    }


    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}