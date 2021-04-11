package by.azot.asutp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "sen_balance")
public class Balance extends AEntity<Long> {

    @Column(name = "name")
    private String name;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "date_begin")
    private Date dateBegin;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "modified_by_user")
    private Long modifiedByUser;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "date_modified")
    private Date dateModified;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sen_balance_sensor", joinColumns = @JoinColumn(name = "balance_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "sensor_id", referencedColumnName = "id"))
    private List<Sensor> sensors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sen_balance_role", joinColumns = @JoinColumn(name = "balance_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;


}
