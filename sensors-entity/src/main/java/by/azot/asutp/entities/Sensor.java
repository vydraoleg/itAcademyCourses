package by.azot.asutp.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "sen_sensor")
public class Sensor extends AEntity<Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "date_begin")
    private Date dateBegin;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "measure")
    private String measure;

    @Column(name = "modified_by_user")
    private Long modifiedByUser;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "date_modified")
    private Date dateModified;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sen_balance_sensor", joinColumns = @JoinColumn(name = "sensor_id", referencedColumnName = "id")
                                          , inverseJoinColumns = @JoinColumn(name = "balance_id", referencedColumnName = "id"))
    private Set<Balance> balances;

}
