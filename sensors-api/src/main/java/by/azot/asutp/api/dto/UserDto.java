package by.azot.asutp.api.dto;

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

    private Long id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private int enabled;
    private List<RoleDto> roles;
}
