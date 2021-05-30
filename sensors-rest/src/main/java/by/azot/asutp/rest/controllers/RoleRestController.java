package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.dto.RoleDto;
import by.azot.asutp.api.services.IRoleService;
import by.azot.asutp.api.services.IUserService;
import by.azot.asutp.rest.api.IControllerUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(IControllerUrl.RESTROLES)
public class RoleRestController implements IControllerUrl {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserService userService;
    @GetMapping
    public List<RoleDto> findRoleRoles() {
        return roleService.getRoles();
    }

    @GetMapping(value = FINDID)
    public RoleDto findRole(@PathVariable Long id) {
        return roleService.findRole(id);
    }

    @PostMapping
    public RoleDto createRole(@RequestBody RoleDto roleDto) {
        return this.roleService.createRole(roleDto);
    }

    @PutMapping(value = FINDID)
    public void updateRole(@PathVariable Long id, @RequestBody RoleDto roleDto) {
        this.roleService.updateRole(id, roleDto);
    }
    @PatchMapping(value = FINDID)
    public void updateRole(@PathVariable Long id, @RequestBody List<RoleDto> roleDto) {
        this.roleService.updateRole(id, roleDto.get(0));
    }

    @DeleteMapping(value = FINDID)
    public void deleteRole(@PathVariable Long id) {
        this.roleService.deleteRole(id);
    }
}
