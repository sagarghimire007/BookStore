package com.bookstore.entity;

import javax.persistence.*;

@Entity
public class Users {


    private Integer userId;
    private String email;
    private String password;


    private String fullName;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    // if the column name on the database and the instance variable differs than use the Column JPA annotation...
    @Column(name = "user_id")
    //maps to the primary key in the database table...
    @Id //
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
