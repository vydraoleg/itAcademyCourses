package by.azot.asutp.services.services;

import by.azot.asutp.api.dao.IRoleJPADao;
import by.azot.asutp.api.dao.IUserJPADao;
import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.api.dto.UserRoleIdsDto;
import by.azot.asutp.api.mappers.UserMapper;
import by.azot.asutp.api.services.IUserService;
import by.azot.asutp.entities.Role;
import by.azot.asutp.entities.User;
import by.azot.asutp.services.utils.LogoFileUploader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private IUserJPADao userJPADao;

    @Autowired
    private IRoleJPADao roleJPADao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto findUser(Long id) {
        User user = this.userJPADao.findById(id).orElse(null);
        return (user != null) ? UserMapper.mapUserDto(user) : null;
    }

    @Override
    public UserDto findUserByFirstName(String username) {
        return UserMapper.mapUserDto(this.userJPADao.findByUserName(username));
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        user.setRole(this.roleJPADao.findById(2L).get());
        User savedUser = this.userJPADao.save(user);
        return UserMapper.mapUserDto(savedUser);
    }

    @Override
    public void updateUser(String userName, UserDto userDto, MultipartFile file) {
        updateUser(this.userJPADao.findByUserName(userName), userDto, file);
    }

    @Override
    public void updateUser(Long id, UserDto userDto, MultipartFile file) {
        updateUser(this.userJPADao.findById(id).get(), userDto, file);
    }

    private void updateUser(User user, UserDto userDto, MultipartFile file) {
        if (user != null) {
            user.setUserName(userDto.getUserName());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            if (userDto.getPassword().trim().length()>0)
                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            this.userJPADao.save(user);
        }
        if (!file.isEmpty()) {
            try {
                LogoFileUploader.updateOrCreateLogo(file, userDto);
            } catch (IOException e) {
                log.error("Failed to upload image. Error message: {}", e.getMessage());
            }
        }
    }

    @Override
    public void updateUser(Long id, UserDto userDto) {
        User user = this.userJPADao.findById(id).orElse(null);
        if (user != null) {
            user.setUserName(userDto.getUserName());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getLastName());
            this.userJPADao.save(user);
        }
    }

    @Override
    public void deleteUser(Long id) {
        this.userJPADao.deleteById(id);
    }

    @Override
    public List<UserDto> getUsers() {
        return UserMapper.mapUserDtos(userJPADao.findAll(Sort.by("userName").ascending()));
    }

    @Override
    public void assignRoleToUser(UserRoleIdsDto ids) {
        User user = this.userJPADao.findById(ids.getUserId()).orElse(null);
        Role role = this.roleJPADao.findById(ids.getRoleId()).orElse(null);
        this.roleJPADao.save(role);
        log.info("Role assigned to user {}!", user.getUserName());
    }

}
