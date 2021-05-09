package by.azot.asutp.api.dao;

import by.azot.asutp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import by.azot.asutp.entities.Sensor;

public interface ISensorJPADao extends JpaRepository<Sensor, Long> {

    Sensor findByName(String sensorName);
}
