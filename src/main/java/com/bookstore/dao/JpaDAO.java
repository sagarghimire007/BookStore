package com.bookstore.dao;

import com.bookstore.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JpaDAO<E> {

    protected  EntityManager entityManager;

    public JpaDAO(EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
    }

    public E create(E entity){

        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();

        return entity;
    }

    public E update(E entity){
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }


    public void deleteUser(Class type, Object id){
        entityManager.getTransaction().begin();
        Object reference = entityManager.getReference(type, id);
        entityManager.remove(reference);
        entityManager.getTransaction().commit();
    }

    protected E find(Class<E> type, Object id) {
        E entity = entityManager.find(type, id);
        return entity;
    }

    public List<E> findWithNamedQuery(String queryName){
        Query query = entityManager.createNamedQuery(queryName);
        return query.getResultList();
    }

    public long countWithNamedQuery(String queryName){
        Query query = entityManager.createNamedQuery(queryName);
        return (long) query.getSingleResult();
    }

    public List<E> findWithNamedQuery(String queryName, String paramName, Object paramValue ){
        Query query = entityManager.createNamedQuery(queryName);
        query.setParameter(paramName, paramValue);
        return query.getResultList();

    }
}
