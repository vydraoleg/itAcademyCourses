package by.azot.asutp.api.services;

import by.azot.asutp.api.dto.SensorDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ISensorService {

    SensorDto findSensor(Long id);

    SensorDto findSensorByName(String firstName);

    SensorDto createSensor(SensorDto user);
    
    void updateSensor(Long id, SensorDto sensorDto, MultipartFile file);

    void updateSensor(Long id, SensorDto sensorDto);

    void deleteSensor(Long id);
    
    List<SensorDto> getSensors();
}
