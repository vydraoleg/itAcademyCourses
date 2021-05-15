package by.azot.asutp.services.services;

import by.azot.asutp.api.dao.ISensorJPADao;
import by.azot.asutp.api.dto.SensorDto;
import by.azot.asutp.api.mappers.SensorMapper;
import by.azot.asutp.api.services.ISensorService;
import by.azot.asutp.entities.Sensor;
import by.azot.asutp.services.utils.LogoFileUploader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SensorService implements ISensorService {

    @Autowired
    private ISensorJPADao sensorDao;

    // TODO
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
    public void updateSensor(Long id, SensorDto sensorDto, MultipartFile file) {
        Sensor sensor = this.sensorDao.findById(id).orElse(null);
        if(sensor != null) {
            sensor = SensorMapper.mapSensor(sensorDto);
            sensor.setId(id);
            this.sensorDao.save(sensor);
        }
        if (!file.isEmpty()) {
            try {
                LogoFileUploader.updateOrCreateLogo(file, sensorDto.getName());
            } catch (IOException e) {
                log.error("Failed to upload image. Error message: {}", e.getMessage());
            }
        }
    }

    @Override
    @Transactional
    public void updateSensor(Long id, SensorDto sensorDto) {
        Sensor sensor = this.sensorDao.findById(id).orElse(null);
        if(sensor != null) {
            sensor = SensorMapper.mapSensor(sensorDto);
            sensor.setId(id);
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
        return SensorMapper.mapSensorDtos(this.sensorDao.findAll(Sort.by("name").ascending()));
    }
}
