package test;

import com.bookstore.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryTest {

    public static void main(String[] args) {

        Category category = new Category();
        category.setCategoryName("Math");

        // 1. Create an Entity Manager Factory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");

        // 2. Create Entity Manager with the help of Entity Manager Factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 3. Begin Transaction
        entityManager.getTransaction().begin();

        // 4. Persist a Users object
        entityManager.persist(category);

        // 5. Commit Transaction
        entityManager.getTransaction().commit();

        // 6. Close the Entity Manager
        entityManager.close();

        // 7. Close the Entity Manager Factory
        entityManagerFactory.close();

        System.out.println("A Category Object was persisted");
    }
}
