package by.azot.asutp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Immutable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Immutable
@Table(name = "sen_vbal_sen_show")
public class VBalSenShow extends AEntity<Long> implements Serializable {

//    @Id
    @Column(name = "balance_id")
    private Long idBalance;

    @Column(name = "name_balance")
    private String nameBalance;

    @Column(name = "name_sensor")
    private String nameSensor;

    @Column(name = "full_name")
    private String fullSensor;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "date_value")
    private Date dateValue;

    @Column(name = "value")
    private Double value;
}
