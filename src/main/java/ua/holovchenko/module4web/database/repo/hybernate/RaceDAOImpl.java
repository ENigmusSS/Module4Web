package ua.holovchenko.module4web.database.repo.hybernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import ua.holovchenko.module4web.database.config.HibernateUtils;
import ua.holovchenko.module4web.database.models.Race;
import ua.holovchenko.module4web.database.repo.interfaces.RaceDAO;

public class RaceDAOImpl extends GenericDAOImpl<Race> implements RaceDAO {
    @Override
    protected void init() {
        aClass = Race.class;
    }

    @Override
    public Race getRaceInfo(String id) {
         try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Race> query = criteriaBuilder.createQuery(aClass);
            Root<Race> from = query.from(aClass);
            query.select(from).where(criteriaBuilder.equal(from.get("start_time"), id));
            return entityManager.createQuery(query).getSingleResult();
        }
    }

    @Override
    public long getRacesCount() {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            TypedQuery<Long> query = entityManager.createQuery("select count(*) from races " , Long.class);
            return query.getSingleResult();
        }
    }


}
