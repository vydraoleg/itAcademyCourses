package by.azot.asutp.dao;

import by.azot.asutp.entities.Sensor;
import liquibase.pro.packaged.T;
import org.springframework.stereotype.Repository;
import by.azot.asutp.api.dao.ISensorDao;

@Repository
public class SensorDao extends AGenericDao<Sensor> implements ISensorDao {

    public SensorDao() {
        super(Sensor.class);
    }
}
