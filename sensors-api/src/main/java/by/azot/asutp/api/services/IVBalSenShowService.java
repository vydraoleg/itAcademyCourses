package by.azot.asutp.api.services;

import by.azot.asutp.api.dto.VBalSenShowDto;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface IVBalSenShowService {

//    VBalSenShow findRecord(Long idBalance, Long id);

/*    VBalSenShow findByName(String Name);

    VBalSenShow createSensor(SensorDto user);
    
    void updateSensor(Long id, SensorDto sensorDto, MultipartFile file);

    void updateSensor(Long id, SensorDto sensorDto);
  */
    void deleteVBalSenShow(Long idBalance,Long id);

    List<VBalSenShowDto> getVBalSenShow(Date date);
}
