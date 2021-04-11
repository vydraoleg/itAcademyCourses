package by.azot.asutp.api.dao;

import by.azot.asutp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleJPADao extends JpaRepository<Role, Long> {
}
