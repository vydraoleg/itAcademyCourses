package by.azot.asutp.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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
    @JoinTable(name = "sen_user_role", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<User> users;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sen_balance_role", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "balance_id", referencedColumnName = "id"))
    private Set<Balance> balances;

    public Role(String roleName){
        this.roleName = roleName;
    }
    public Role(Long id, String roleName){
        this.id = id;
        this.roleName = roleName;
    }
}
