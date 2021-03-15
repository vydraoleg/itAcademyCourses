package by.azot.asutp.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.azot.asutp.api.dao.IUserDao;
import by.azot.asutp.entities.User;

@Repository
public class UserDao extends AGenericDao<User> implements IUserDao {

    public UserDao() {
        super(User.class);
    }
    
//    public User getByName(String firstName) throws NoResultException {
//        try {
//            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//            CriteriaQuery<User> query = builder.createQuery(getGenericClass());
//            Root<User> companyDetailsRoot = query.from(User.class);
//            query.select(companyDetailsRoot).where(builder.equal(companyDetailsRoot.get(User_.firstName), firstName));
//            TypedQuery<User> result = entityManager.createQuery(query);
//            return result.getSingleResult();
//        } catch (NoResultException e) {
//            throw new NoResultException(e.getMessage());
//        }
//    }
}
