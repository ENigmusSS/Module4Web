package ua.holovchenko.module4web.database.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import static jakarta.persistence.Persistence.createEntityManagerFactory;


public class HibernateUtils {


    private static EntityManager configureEntityManager() {
        EntityManagerFactory factory = createEntityManagerFactory("totalizatorrr");
        return factory.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return configureEntityManager();
    }
}