package by.azot.asutp.api.mappers;

import by.azot.asutp.api.dto.SensorDto;
import by.azot.asutp.api.dto.VBalSenShowDto;
import by.azot.asutp.entities.Sensor;
import by.azot.asutp.entities.VBalSenShow;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class VBalSenShowMapper {

    public VBalSenShow mapVBalSenShow(VBalSenShowDto source) {
        return VBalSenShow.builder()
                .id(source.getId())
                .idBalance(source.getIdBalance())
                .nameBalance(source.getNameBalance())
                .nameSensor(source.getNameSensor())
                .fullSensor(source.getFullSensor())
                .dateValue(source.getDateValue())
                .value(source.getValue())
                .build();
    }

    public VBalSenShowDto mapVBalSenShowDto(VBalSenShow source) {
        return VBalSenShowDto.builder()
                .id(source.getId())
                .idBalance(source.getIdBalance())
                .nameBalance(source.getNameBalance())
                .nameSensor(source.getNameSensor())
                .fullSensor(source.getFullSensor())
                .dateValue(source.getDateValue())
                .value(source.getValue())
                .build();
    }

    public List<VBalSenShow> mapVBalSenShows(List<VBalSenShowDto> source) {
        return source.stream().map(VBalSenShowMapper::mapVBalSenShow).collect(Collectors.toList());
    }
    
    public List<VBalSenShowDto> mapVBalSenShowDtos(List<VBalSenShow> source) {
        return source.stream().map(VBalSenShowMapper::mapVBalSenShowDto).collect(Collectors.toList());
    }
}
