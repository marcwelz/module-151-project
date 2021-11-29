package ch.bbw.mw.projekt.persistence;

import ch.bbw.mw.projekt.model.Login;
import ch.bbw.mw.projekt.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LoginPersistence {
    private static EntityManagerFactory factory;
    private static EntityManager manager;

    public LoginPersistence() {
        factory = Persistence.createEntityManagerFactory("MyPersistanceUnit");
        manager = factory.createEntityManager();

    }

    public void close() {
        factory.close();
        manager.close();
    }

    public List<User> getAllLogins() {
        List logins = null;
        try {
            manager.getTransaction().begin();
            logins = manager.createQuery("FROM Login", Login.class).getResultList();
            manager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        }

        return logins;
    }

    public void addLogin(Login login) {
        manager.getTransaction().begin();
        manager.persist(login);
        manager.getTransaction().commit();
    }
}
