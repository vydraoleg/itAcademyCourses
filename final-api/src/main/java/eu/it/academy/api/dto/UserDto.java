package eu.it.academy.api.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private int id;
    private String firstName;
    private int salary;
    private List<PetDto> pets;
    @Builder.Default
    private String roleName = "ROLE_USER";

}
