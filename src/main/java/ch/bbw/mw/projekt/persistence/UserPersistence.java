package ch.bbw.mw.projekt.persistence;

import ch.bbw.mw.projekt.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserPersistence {
    private static EntityManagerFactory factory;
    private static EntityManager manager;

    public UserPersistence() {
        factory = Persistence.createEntityManagerFactory("MyPersistanceUnit");
        manager = factory.createEntityManager();

    }

    public void close() {
        factory.close();
        manager.close();
    }

    public List<User> getAllUser() {
        List user = null;
        try {
            manager.getTransaction().begin();
            user = manager.createQuery("FROM User", User.class).getResultList();
            manager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        }

        return user;
    }

    public void addUser(User user) {
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
    }
}
