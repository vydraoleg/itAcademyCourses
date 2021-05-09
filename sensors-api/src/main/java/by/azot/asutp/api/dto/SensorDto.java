package by.azot.asutp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensorDto {

    private Long id;
    private String name;
    private String fullName;
    private Date dateBegin;
    private Date dateEnd;
    private String measure;
    private Long modifiedByUser;
    private Date dateModified;
}
