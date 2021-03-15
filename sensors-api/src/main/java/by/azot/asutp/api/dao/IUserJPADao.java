package by.azot.asutp.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import by.azot.asutp.entities.User;

public interface IUserJPADao extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
