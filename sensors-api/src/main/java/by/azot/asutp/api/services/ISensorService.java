package by.azot.asutp.api.services;

import java.util.List;

import by.azot.asutp.api.dto.UserDto;
import org.springframework.stereotype.Service;

import by.azot.asutp.api.dto.SensorDto;

@Service
public interface ISensorService {

    SensorDto findSensor(Long id);

    SensorDto findSensorByName(String firstName);

    SensorDto createSensor(SensorDto user);
    
    void updateSensor(Long id, SensorDto user);
    
    void deleteSensor(Long id);
    
    List<SensorDto> getSensors();
}
