package com.bookstore.entity;

import javax.persistence.*;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "book", indexes = { @Index(name = "category_id_fk_idx", columnList = "category_id")})

@NamedQueries({
        @NamedQuery(name = "Books.findAll", query = "select b from Book b"),
        @NamedQuery(name = "Books.countBooks", query = "select count(*) from Book b"),
        @NamedQuery(name = "Books.findByTitle", query = "select b from Book b where b.title =: title")



})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "author", nullable = false, length = 64)
    private String author;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "isbn_number", nullable = false, length = 15)
    private String isbnNumber;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "publish_date", nullable = false)
    private Date publishDate;

    @Column(name = "last_update_time", nullable = false)
    private Date lastUpdateTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "book")
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<Review> reviews = new LinkedHashSet<>();

    @Transient
    private String base64Image;

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // transient states that there is no mapping between the object and database attributes
    @Transient
    public String getBase64Image(){
        this.base64Image = Base64.getEncoder().encodeToString(this.image);
        return this.base64Image;
    }

    @Transient
    public void setBase64Image(String base64Image){
        this.base64Image = base64Image;
    }
}