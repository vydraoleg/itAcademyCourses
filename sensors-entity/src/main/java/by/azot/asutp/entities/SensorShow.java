package by.azot.asutp.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity

@Table(name = "sen_sensor_show")
public class SensorShow implements Serializable {

    @Id
    @Column(name = "sensor_id")
    private Long idSensor;

    @Id
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "date_value")
    private Date dateValue;

    @Column(name = "value")
    private Double value;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinTable(name = "sen_sensor", joinColumns = @JoinColumn(name = "id", referencedColumnName = "sensor_id"))
//    private Sensor sensor;

}
