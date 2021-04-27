package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.api.services.IUserService;
import by.azot.asutp.utils.mail.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UserController {

    @Value("${server.max-records-per-page}")
    private int maxRecordPerPage;

    @Autowired
    private IUserService userService;


    @GetMapping(value = "/page={page}")
    public ModelAndView findUsers(@PathVariable int page) {
        List<UserDto> users = userService.getUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersPage");
        modelAndView.addObject("title", "My Users:");
        modelAndView.addObject("page", page);
        modelAndView.addObject("allPages", users.size());
        if (users.size() < maxRecordPerPage)
            modelAndView.addObject("usersList", users);
        else {
            if (users.size() < page * maxRecordPerPage && users.size() > maxRecordPerPage)
                page = users.size() / maxRecordPerPage;
            List<UserDto> usersList = new ArrayList<UserDto>(users.subList((page - 1) * maxRecordPerPage, page * maxRecordPerPage));
            modelAndView.addObject("usersList", usersList);
        }
        return modelAndView;
    }

    @GetMapping
    public ModelAndView findUsersFirstPage() {
        return this.findUsers(1);
    }

    @GetMapping(value = "/{id}")
    public ModelAndView findUser(@PathVariable Long id) {
        UserDto userDto = userService.findUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPage");
        modelAndView.addObject("user", userDto);
        return modelAndView;
    }

    @GetMapping(value = "/name/{firstName}")
    public ModelAndView findUserByFirstName(@PathVariable String firstName) {
        UserDto userDto = userService.findUserByFirstName(firstName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPage");
        modelAndView.addObject("user", userDto);
        return modelAndView;
    }

    //===============create=================

    @GetMapping(value = "/add")
    public ModelAndView createUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersFormPage");
        modelAndView.addObject("user", new UserDto());
        modelAndView.addObject("title", "Add new user");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public String createUserSubmit(UserDto user, Model model) {
//        UserDto userDto = this.userService.createUser(user);
        this.SendEmailAdmin(user);
        return "redirect:/users";
    }

    //===============update=================

    @GetMapping(value = "/upd/{id}")
    public ModelAndView updateUser(@PathVariable(value = "id") long id) {
        UserDto userDto = userService.findUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersFormPageUpd");
        modelAndView.addObject("user", userDto);
        modelAndView.addObject("title", "Update user:");
        return modelAndView;
    }

    @PostMapping(value = "/upd/{id}")
    public String updateUser(@PathVariable(value = "id") long id, UserDto user, @RequestParam(value = "file", required = false) MultipartFile file, Model model) {
        this.userService.updateUser(id, user, file);
        return "redirect:/users";
    }

    @PostMapping("/remove/{id}")
    public String deleteUserPost(@PathVariable(value = "id") long id, Model model) {
        this.userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/remove/{id}")
    public String deleteUser(@PathVariable(value = "id") long id, Model model) {
        this.userService.deleteUser(id);
        return "redirect:/users";
    }

    public void SendEmailAdmin(UserDto user) {
        try {
            EmailSender myMailSender = new EmailSender();
            myMailSender.sendEmailToAdmin(user, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

