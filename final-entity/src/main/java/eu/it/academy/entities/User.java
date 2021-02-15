package eu.it.academy.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "user_table")
public class User extends AEntity<Integer> {

    @Column(name = "user_name")
    private String firstName;
    @Column(name = "user_salary")
    private int salary;
//    @OneToMany(mappedBy = "user_table", fetch = FetchType.LAZY)
//    private List<Pet> pets;
}
