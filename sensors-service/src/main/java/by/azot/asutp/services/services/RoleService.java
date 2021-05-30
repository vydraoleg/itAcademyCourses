package by.azot.asutp.services.services;

import by.azot.asutp.api.dao.IRoleJPADao;
import by.azot.asutp.api.dao.IUserJPADao;
import by.azot.asutp.api.dto.RoleDto;
import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.api.dto.UserRoleIdsDto;
import by.azot.asutp.api.mappers.RoleMapper;
import by.azot.asutp.api.mappers.UserMapper;
import by.azot.asutp.api.services.IRoleService;
import by.azot.asutp.api.services.IUserService;
import by.azot.asutp.dao.RoleDao;
import by.azot.asutp.dao.UserDao;
import by.azot.asutp.entities.Role;
import by.azot.asutp.entities.User;
import by.azot.asutp.services.utils.LogoFileUploader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class RoleService implements IRoleService {

    @Autowired
    private IRoleJPADao roleJPADao;

    @Override
    public RoleDto findRole(Long id) {
        Role role = this.roleJPADao.findById(id).orElse(null);
        return (role != null) ? RoleMapper.mapRoleDto(role) : null;
    }

    @Override
    public RoleDto findRoleByName(String name) {
        return RoleMapper.mapRoleDto(this.roleJPADao.findByRoleName(name));
    }

    @Override
    @Transactional
    public RoleDto createRole(RoleDto roleDto) {
        Role role = new Role();
        role.setRoleName(roleDto.getRoleName());
        Role savedRole = this.roleJPADao.save(role);
        return RoleMapper.mapRoleDto(savedRole);
    }

    /**
     * Changing name from ROLE if not exists create new ROLE
     * @param id
     * @param roleDto
     */
    @Override
    @Transactional
    public void updateRole(Long id, RoleDto roleDto) {
        Role role = roleJPADao.findById(id).orElse(null);
        if (role != null) {
            role.setRoleName(roleDto.getRoleName());
            this.roleJPADao.save(role);
        }else{
            createRole(roleDto);
        }
    }

    @Override
    public void deleteRole(Long id) {
        this.roleJPADao.deleteById(id);
    }

    @Override
    public List<RoleDto> getRoles() {
        return RoleMapper.mapRoleDtos(roleJPADao.findAll(Sort.by("roleName").descending()));
    }
}
