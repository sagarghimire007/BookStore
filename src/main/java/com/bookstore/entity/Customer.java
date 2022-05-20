package com.bookstore.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "customer", indexes = { @Index(name = "email_UNIQUE", columnList = "email", unique = true) , @Index(name = "phone_number_UNIQUE", columnList = "phone_number", unique = true) })
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "full_name", nullable = false, length = 45)
    private String fullName;

    @Column(name = "address", nullable = false, length = 128)
    private String address;

    @Column(name = "city", nullable = false, length = 32)
    private String city;

    @Column(name = "country", nullable = false, length = 24)
    private String country;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "zipcode", nullable = false, length = 24)
    private String zipcode;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Column(name = "register_date", nullable = false)
    private Instant registerDate;

    @OneToMany(mappedBy = "customer")
    private Set<BookOrder> bookOrders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<Review> reviews = new LinkedHashSet<>();

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<BookOrder> getBookOrders() {
        return bookOrders;
    }

    public void setBookOrders(Set<BookOrder> bookOrders) {
        this.bookOrders = bookOrders;
    }

    public Instant getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Instant registerDate) {
        this.registerDate = registerDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}