package by.azot.asutp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {

    private Long id;
    private String roleName;
    private String description;
    private List<UserDto> userDtos;
    private List<BalanceDto> balanceDtos;
}
