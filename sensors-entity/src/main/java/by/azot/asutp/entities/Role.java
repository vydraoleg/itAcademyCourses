package by.azot.asutp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "sen_role")
public class Role extends AEntity<Long> {

    @Column(name = "name")
    private String roleName;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sen_user_role", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<User> users;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sen_balance_role", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "balance_id", referencedColumnName = "id"))
    private Set<Balance> balances;
}
