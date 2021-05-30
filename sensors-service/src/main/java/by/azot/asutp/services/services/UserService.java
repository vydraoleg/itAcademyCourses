package by.azot.asutp.services.services;

import by.azot.asutp.api.dao.IRoleJPADao;
import by.azot.asutp.api.dao.IUserJPADao;
import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.api.dto.UserRoleIdsDto;
import by.azot.asutp.api.mappers.UserMapper;
import by.azot.asutp.api.services.IUserService;
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
    public UserDto findUserByUserName(String username) {
        return UserMapper.mapUserDto(this.userJPADao.findByUserName(username));
//        return UserMapper.mapUserDto(this.userDao.getByName(username));
    }

    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        Role role = this.roleJPADao.findById(2L).orElse(null);
        user.setRole(role);
        User savedUser = this.userJPADao.save(user);
        return UserMapper.mapUserDto(savedUser);
    }

    @Override
    @Transactional
    public void updateUser(String userName, UserDto userDto, MultipartFile file) {
        updateUser(this.userJPADao.findByUserName(userName), userDto, file);
    }

    @Override
    @Transactional
    public void updateUser(Long id, UserDto userDto, MultipartFile file) {
        updateUser(this.userJPADao.findById(id).get(), userDto, file);
    }

    @Transactional
    private void updateUser(User user, UserDto userDto, MultipartFile file) {
        if (user != null) {
            String pw = user.getPassword();
            user=UserMapper.mapUser(userDto);
            if (userDto.getPassword()!=null)
                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            else
                user.setPassword(pw);
            this.userJPADao.save(user);
        }
        if (!file.isEmpty()) {
            try {
                LogoFileUploader.updateOrCreateLogo(file, userDto.getUserName());
            } catch (IOException e) {
                log.error("Failed to upload image. Error message: {}", e.getMessage());
            }
        }
    }

    @Override
    @Transactional
    public void updateUser(Long id, UserDto userDto) {
        User user = this.userJPADao.findById(id).orElse(null);
        if (user != null) {
            user = UserMapper.mapUser(userDto);
            user.setId(id); // чтобы не переписывать все свойства из предыдущего свойства
            this.userJPADao.save(user);
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        this.userJPADao.deleteById(id);
    }

    @Override
    public List<UserDto> getUsers() {
        return UserMapper.mapUserDtos(userJPADao.findAll(Sort.by("userName").ascending()));
    }

    @Override
    @Transactional
    public void assignRoleToUser(UserRoleIdsDto ids) {
        User user = this.userJPADao.findById(ids.getUserId()).orElse(null);
        Role role = this.roleJPADao.findById(ids.getRoleId()).orElse(null);
        this.roleJPADao.save(role);
        log.info("Role assigned to user {}!", user.getUserName());
    }

}
