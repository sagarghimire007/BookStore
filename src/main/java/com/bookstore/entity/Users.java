package com.bookstore.entity;

import javax.persistence.*;

@Entity

@NamedQueries({
        @NamedQuery(name = "Users.findAll", query = "select u from Users u"),
        @NamedQuery(name = "Users.countAll", query = "select count(*) from Users u"),
        @NamedQuery(name = "Users.findByEmail", query = "select u from Users u where u.email =: email"),
        @NamedQuery(name = "Users.checkLogin", query = "select u from Users u where u.email =: email AND u.password =: password")
})

@Table(name = "users", indexes = { @Index(name = "email_UNIQUE", columnList = "email", unique = true) })

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Column(name = "full_name", nullable = false, length = 30)
    private String fullName;

    @Column(name = "password", nullable = false, length = 30)
    private String password;


    public Users() {

    }

    public Users(String email , String fullName , String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    public Users(Integer userId , String email , String fullName , String password) {
        this.id = userId;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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