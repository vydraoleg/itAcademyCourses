package by.azot.asutp.api.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VBalSenShowDto {

    private Long id;
    private Long idBalance;
    private String nameBalance;
    private String nameSensor;
    private String fullSensor;
    private Date dateValue;
    private Double previousValue;
    private Double value;

}
