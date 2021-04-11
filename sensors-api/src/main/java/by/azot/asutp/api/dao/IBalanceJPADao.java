package by.azot.asutp.api.dao;

import by.azot.asutp.entities.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBalanceJPADao extends JpaRepository<Balance, Long> {

}
