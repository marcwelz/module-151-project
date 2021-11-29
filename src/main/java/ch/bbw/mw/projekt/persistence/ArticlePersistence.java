package ch.bbw.mw.projekt.persistence;

import ch.bbw.mw.projekt.model.Article;
import ch.bbw.mw.projekt.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ArticlePersistence {
    private static EntityManagerFactory factory;
    private static EntityManager manager;

    public ArticlePersistence() {
        factory = Persistence.createEntityManagerFactory("MyPersistanceUnit");
        manager = factory.createEntityManager();

    }

    public void close() {
        factory.close();
        manager.close();
    }

    public List<User> getAllArticle() {
        List articles = null;
        try {
            manager.getTransaction().begin();
            articles = manager.createQuery("FROM Article", Article.class).getResultList();
            manager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        }

        return articles;
    }

    public void addArticle(Article article) {
        manager.getTransaction().begin();
        manager.persist(article);
        manager.getTransaction().commit();
    }
}
