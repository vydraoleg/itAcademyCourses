package by.azot.asutp.api.dao;

import by.azot.asutp.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISensorJPADao extends JpaRepository<Sensor, Long> {

    Sensor findByName(String sensorName);
}
