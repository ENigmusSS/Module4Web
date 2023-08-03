package ua.holovchenko.module4web.database.repo.hybernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import ua.holovchenko.module4web.database.config.HibernateUtils;
import ua.holovchenko.module4web.database.repo.interfaces.GenericDAO;

import java.util.List;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {
    protected Class<T> aClass;

    public GenericDAOImpl() {
        init();
    }

    protected abstract void init();

    @Override
    public List<T> getAll() {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(aClass);
        Root<T> from = query.from(aClass);
        query.select(from);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void save(T obj) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(obj);
        entityManager.flush();
        transaction.commit();
    }

    @Override
    public void delete(T obj) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(obj);
        entityManager.flush();
        transaction.commit();
    }
}
