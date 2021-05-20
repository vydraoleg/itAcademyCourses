package by.azot.asutp.api.dao;

import by.azot.asutp.entities.VBalSenShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface IVBalSenShowJPADao extends JpaRepository<VBalSenShow, Long> {

    List<VBalSenShow> findByDateValue(Date date);

}
