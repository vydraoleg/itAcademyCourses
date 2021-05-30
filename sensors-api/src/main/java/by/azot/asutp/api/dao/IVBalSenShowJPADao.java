package by.azot.asutp.api.dao;

import by.azot.asutp.entities.VBalSenShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface IVBalSenShowJPADao extends JpaRepository<VBalSenShow, Long> {

    List<VBalSenShow> findByDateValue(Date date);

    @Query(value="delete from sen_balance_sensor sbs where sbs.balance_id = ?1 and sbs.sensor_id = ?2", nativeQuery = true)
    void deleteVBalSenShow(Long idBalance, Long id);
}
