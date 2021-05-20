package by.azot.asutp.api.dao;

import by.azot.asutp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJPADao extends JpaRepository<User, Long> {

    User findByUserName(String userName);

}
