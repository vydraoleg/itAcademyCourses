package by.azot.asutp.api.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.api.dto.UserPetIdsDto;

@Service
public interface IUserService {

    UserDto findUser(Long id);
    
    UserDto findUserByFirstName(String firstName);
    
    UserDto createUser(UserDto user);
    
    void updateUser(String firstName, UserDto user, MultipartFile file);

    void updateUser(Long id, UserDto user);

    void deleteUser(Long id);
    
    List<UserDto> getUsers();

    void assingPetToUser(UserPetIdsDto ids);
}
