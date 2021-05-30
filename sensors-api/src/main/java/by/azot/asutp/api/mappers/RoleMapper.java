package by.azot.asutp.api.mappers;

import by.azot.asutp.api.dto.RoleDto;
import by.azot.asutp.entities.Role;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class RoleMapper {

    public Role mapRole(RoleDto source) {
        return Role.builder()
                .id(source.getId())
                .roleName(source.getRoleName())
                .description(source.getDescription())
                .build();
    }

    public RoleDto mapRoleDto(Role source) {
        return RoleDto.builder()
                .id(source.getId())
                .roleName(source.getRoleName())
                .description(source.getDescription())
                .build();
    }

    public List<Role> mapRoles(List<RoleDto> source) {
        return source.stream().map(RoleMapper::mapRole).collect(Collectors.toList());
    }
    
    public List<RoleDto> mapRoleDtos(List<Role> source) {
        return source.stream().map(RoleMapper::mapRoleDto).collect(Collectors.toList());
    }
}
