package by.azot.asutp.api.utils;

import org.springframework.stereotype.Service;

import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.entities.User;

@Service
public interface IEmailSender {

    void sendEmailToAdmin(UserDto dto, int status) throws Exception;

    void sendEmailFromAdmin(User user, int status) throws Exception;
}
