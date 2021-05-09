package by.azot.asutp.services.services;

import java.util.List;

import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.api.mappers.UserMapper;
import by.azot.asutp.api.services.ISensorService;
import by.azot.asutp.entities.Role;
import by.azot.asutp.entities.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import by.azot.asutp.api.dao.ISensorJPADao;
import by.azot.asutp.api.dto.SensorDto;
import by.azot.asutp.api.mappers.SensorMapper;

@Service
public class SensorService implements ISensorService {

    @Autowired
    private ISensorJPADao sensorDao;

    @Override
    public SensorDto findSensor(Long id) {
        Sensor sensor = this.sensorDao.findById(id).orElse(null);
        return (sensor != null ) ? SensorMapper.mapSensorDto(sensor) : null;
    }

    @Override
    public SensorDto findSensorByName(String sensorName) {
        return SensorMapper.mapSensorDto(this.sensorDao.findByName(sensorName));
    }

    @Override
    @Transactional
    public SensorDto createSensor(SensorDto sensor) {
        Sensor entity = SensorMapper.mapSensor(sensor);
        return SensorMapper.mapSensorDto(this.sensorDao.save(entity));
    }

    @Override
    @Transactional
    public void updateSensor(Long id, SensorDto sensorDto) {
        Sensor sensor = this.sensorDao.findById(id).orElse(null);
        if(sensor != null) {
            this.sensorDao.save(sensor);
        }
    }

    @Override
    @Transactional
    public void deleteSensor(Long id) {
        this.sensorDao.deleteById(id);
    }

    @Override
    public List<SensorDto> getSensors() {
        return SensorMapper.mapSensorDtos(this.sensorDao.findAll());
    }
}
