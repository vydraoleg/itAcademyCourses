package by.azot.asutp.dao;

import by.azot.asutp.api.dao.IUserDao;
import by.azot.asutp.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class UserDao extends AGenericDao<User> implements IUserDao {

    public UserDao() {
        super(User.class);
    }
    
    public User getByName(String userName) throws NoResultException {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(getGenericClass());   //User.class
            Root<User> userRoot = query.from(getGenericClass());
            query.where(builder.and(builder.equal(userRoot.get("userName"), userName)));
            TypedQuery<User> result = entityManager.createQuery(query);
            return result.getSingleResult();
        } catch (NoResultException e) {
            throw new NoResultException(e.getMessage());
        }
    }
}
