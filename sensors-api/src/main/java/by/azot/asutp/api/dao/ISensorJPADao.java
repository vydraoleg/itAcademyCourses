package by.azot.asutp.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import by.azot.asutp.entities.Sensor;

public interface ISensorJPADao extends JpaRepository<Sensor, Long> {

}
