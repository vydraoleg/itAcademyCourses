package by.azot.asutp.dao;

import by.azot.asutp.api.dao.IVBalSenShowDao;
import by.azot.asutp.entities.VBalSenShow;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;

@Repository
public class VBalSenShowDao extends AGenericDao<VBalSenShow> implements IVBalSenShowDao {

    public VBalSenShowDao() {
        super(VBalSenShow.class);
    }

    public List<VBalSenShow> findByIdDateValue(Long id, Date date) throws NoResultException {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<VBalSenShow> query = builder.createQuery(getGenericClass());   //User.class
            Root<VBalSenShow> curRoot = query.from(getGenericClass());
            query.where(builder.and(builder.equal(curRoot.get("idBalance"), id)
                                  , builder.equal(curRoot.get("dateValue"), date))) ;
            TypedQuery<VBalSenShow> result = entityManager.createQuery(query);
            return result.getResultList();
        } catch (NoResultException e) {
            throw new NoResultException(e.getMessage());
        }
    }
}
