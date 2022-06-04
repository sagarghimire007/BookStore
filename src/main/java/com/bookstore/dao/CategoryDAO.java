package com.bookstore.dao;

import com.bookstore.entity.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

    public CategoryDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
   public Category create(Category category){
        return super.create(category);
   }

   @Override
   public Category update(Category category){
        return super.update(category);
   }
    @Override
    public Category get(Object categoryId) {
        return super.find(Category.class, categoryId);
    }

    @Override
    public void delete(Object categoryId) {
        super.delete(Category.class, categoryId);
    }

    @Override
    public List<Category> listAll() {
        return super.findWithNamedQuery("Category.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Category.countCategory");
    }

    public Category findByCategoryName(String categoryName){
        List<Category> category = findWithNamedQuery("Category.findByCategoryName", "categoryName", categoryName);
        if(category != null && category.size() > 0){
            return category.get(0);
        }
        return null;
    }
}
