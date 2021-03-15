package by.azot.asutp.api.mappers;

import java.util.List;
import java.util.stream.Collectors;

import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.entities.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public User mapUser(UserDto source) {
        return User.builder()
                .id(source.getId())
                .username(source.getUsername())
                .salary(source.getSalary())
                .password(source.getPassword())
                .build();
    }

    public UserDto mapUserDto(User source) {
        return UserDto.builder()
                .id(source.getId())
                .username(source.getUserName())
                .salary(source.getSalary())
                .password(source.getPassword())
                .build();
    }

    public List<User> mapUsers(List<UserDto> source) {
        return source.stream().map(UserMapper::mapUser).collect(Collectors.toList());
    }
    
    public List<UserDto> mapUserDtos(List<User> source) {
        return source.stream().map(UserMapper::mapUserDto).collect(Collectors.toList());
    }
}
