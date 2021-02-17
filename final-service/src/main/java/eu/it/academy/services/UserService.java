package eu.it.academy.services;

import eu.it.academy.api.dao.IUserDao;
import eu.it.academy.api.services.IUserService;
import eu.it.academy.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;
    
    public User findUser(int id) {

        return this.userDao.findUser(id);
    }
}
