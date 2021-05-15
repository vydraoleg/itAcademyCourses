package by.azot.asutp.api.dao;

import by.azot.asutp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Column;

public interface IUserJPADao extends JpaRepository<User, Long> {

    User findByUserName(String userName);

}
