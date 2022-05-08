package test;

import com.bookstore.entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class UsersTest {
    public static void main(String[] args) {


        Users users1 = new Users();
        users1.setEmail("padmabhusal@gmail.com");
        users1.setFullName("Padma Bhusal");
        users1.setPassword("padma");

        // 1. Create an Entity Manager Factory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");

        // 2. Create Entity Manager with the help of Entity Manager Factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 3. Begin Transaction
        entityManager.getTransaction().begin();

        // 4. Persist a Users object
        entityManager.persist(users1);

        // 5. Commit Transaction
        entityManager.getTransaction().commit();

        // 6. Close the Entity Manager
        entityManager.close();

        // 7. Close the Entity Manager Factory
        entityManagerFactory.close();

        System.out.println("A User Object was persisted");
    }
}
