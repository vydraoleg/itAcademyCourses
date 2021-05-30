package by.azot.asutp.api.services;

import by.azot.asutp.api.dto.RoleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRoleService {

    RoleDto findRole(Long id);

    RoleDto findRoleByName(String name);

    RoleDto createRole(RoleDto roleDto);
    
    void updateRole(Long id, RoleDto roleDto);

    void deleteRole(Long id);

    List<RoleDto> getRoles();
}
