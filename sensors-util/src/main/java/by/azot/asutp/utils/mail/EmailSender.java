package by.azot.asutp.utils.mail;

import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.api.mappers.UserMapper;
import by.azot.asutp.api.utils.IEmailSender;
import by.azot.asutp.entities.User;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.StringWriter;

@Service
public class EmailSender implements IEmailSender {

    private static final String ADMIN_EMAIL_ADDRESS = "vydraoleg@gmail.com";

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private JavaMailSender mailSender;

    @Async
    @Override
    public void sendEmailToAdmin(UserDto dto, int status) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        String statusValue = (status == 1) ? "activate" : "deactivate";
        String text = prepareActivateRequestEmail(dto, statusValue);
        String subjext = new StringBuilder("HTPVacancy System request to ").append(statusValue).append(" the User.")
                .toString();
        configureMimeMessageHelper(helper, ADMIN_EMAIL_ADDRESS, ADMIN_EMAIL_ADDRESS, text, subjext);
        mailSender.send(message);
    }

    @Async
    @Override
    public void sendEmailFromAdmin(User user, int status) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        UserDto userDto = UserMapper.mapUserDto(user);
        String text = prepareStatusChangingMailText(userDto, status);
        configureMimeMessageHelper(helper, ADMIN_EMAIL_ADDRESS, ADMIN_EMAIL_ADDRESS, text,
                "User status change in HTPVacancy System");
        mailSender.send(message);
    }

    private void configureMimeMessageHelper(MimeMessageHelper helper, String mailFrom, String mailTo, String mailText,
            String mailSubject) throws MessagingException {
        helper.setFrom(mailFrom);
        helper.setTo(mailTo);
        helper.setText(mailText, true);
        helper.setSubject(mailSubject);
    }

    private String prepareStatusChangingMailText(UserDto userDto, int status) {
        String statusValue = (status == 1) ? "activated" : "deactivated";
        VelocityContext context = createVelocityContextWithBasicParameters(userDto, statusValue);
        StringWriter stringWriter = new StringWriter();
        velocityEngine.mergeTemplate("mailtemplates/statusChange.vm", "UTF-8", context, stringWriter);
        return stringWriter.toString();
    }

    private String prepareActivateRequestEmail(UserDto userDto, String statusValue) {
        VelocityContext context = createVelocityContextWithBasicParameters(userDto, statusValue);
        StringWriter stringWriter = new StringWriter();
        velocityEngine.mergeTemplate("mailtemplates/activate.vm", "UTF-8", context, stringWriter);
        return stringWriter.toString();
    }

    private VelocityContext createVelocityContextWithBasicParameters(UserDto userDto, String status) {
        VelocityContext context = new VelocityContext();
        context.put("userName", userDto.getUsername());
        context.put("status", status);
        return context;
    }

}
