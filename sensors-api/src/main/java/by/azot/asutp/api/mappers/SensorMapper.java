package by.azot.asutp.api.mappers;

import java.util.List;
import java.util.stream.Collectors;
import by.azot.asutp.api.dto.SensorDto;
import by.azot.asutp.entities.Sensor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SensorMapper {

    public Sensor mapSensor(SensorDto source) {
        return Sensor.builder()
                .id(source.getId())
                .name(source.getName())
                .fullName(source.getFullName())
                .measure(source.getMeasure())
                .dateBegin(source.getDateBegin())
                .dateEnd(source.getDateEnd())
                .modifiedByUser(source.getModifiedByUser())
                .dateModified(source.getDateModified())
                .build();
    }

    public SensorDto mapSensorDto(Sensor source) {
        return SensorDto.builder()
                .id(source.getId())
                .name(source.getName())
                .fullName(source.getFullName())
                .measure(source.getMeasure())
                .dateBegin(source.getDateBegin())
                .dateEnd(source.getDateEnd())
                .modifiedByUser(source.getModifiedByUser())
                .dateModified(source.getDateModified())
                .build();
    }

    public List<Sensor> mapSensors(List<SensorDto> source) {
        return source.stream().map(SensorMapper::mapSensor).collect(Collectors.toList());
    }
    
    public List<SensorDto> mapSensorDtos(List<Sensor> source) {
        return source.stream().map(SensorMapper::mapSensorDto).collect(Collectors.toList());
    }
}
