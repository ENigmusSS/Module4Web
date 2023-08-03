package ua.holovchenko.module4web.database.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.holovchenko.module4web.database.models.HorseRun;
import ua.holovchenko.module4web.database.models.Race;
import static jakarta.persistence.Persistence.createEntityManagerFactory;


public class HibernateUtils {
    private static SessionFactory factory;
    private static EntityManager entityManager;

    private static void configureFactory() {
        try {
            factory = new Configuration()
                    .addAnnotatedClass(Race.class)
                    .addAnnotatedClass(HorseRun.class)
                    .configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static void configureEntityManager() {
        EntityManagerFactory factory = createEntityManagerFactory("totalizatorrr");
        entityManager = factory.createEntityManager();
    }

    public static SessionFactory getFactory() {
        if (factory == null) {
            configureFactory();
        }
        return factory;
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            configureEntityManager();
        }
        return entityManager;
    }


}