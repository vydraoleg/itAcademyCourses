package by.azot.asutp.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import by.azot.asutp.api.dto.SensorDto;

@Service
public interface ISensorService {

    SensorDto findSensor(Long id);
    
    SensorDto createSensor(SensorDto user);
    
    void updateSensor(Long id, SensorDto user);
    
    void deleteSensor(Long id);
    
    List<SensorDto> getSensors();
}
