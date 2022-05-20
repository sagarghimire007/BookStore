package com.bookstore.dao;

import com.bookstore.entity.Users;

import javax.persistence.EntityManager;
import java.util.List;

public class UsersDAO extends JpaDAO<Users> implements GenericDAO<Users>{

    public UsersDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public Users create(Users user){
        return super.create(user);
    }

    @Override
    public Users update(Users user) {
        return  super.update(user);
    }

    @Override
    public Users get(Object id) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List listAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
