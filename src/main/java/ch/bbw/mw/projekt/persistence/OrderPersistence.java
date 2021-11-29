package ch.bbw.mw.projekt.persistence;

import ch.bbw.mw.projekt.model.Order;
import ch.bbw.mw.projekt.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class OrderPersistence {

    private static EntityManagerFactory factory;
    private static EntityManager manager;

    public OrderPersistence() {
        factory = Persistence.createEntityManagerFactory("MyPersistanceUnit");
        manager = factory.createEntityManager();

    }

    public void close() {
        factory.close();
        manager.close();
    }

    public List<User> getAllOrders() {
        List orders = null;
        try {
            manager.getTransaction().begin();
            orders = manager.createQuery("FROM Order", Order.class).getResultList();
            manager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        }

        return orders;
    }

    public void addOrder(Order order) {
        manager.getTransaction().begin();
        manager.persist(order);
        manager.getTransaction().commit();
    }
}
