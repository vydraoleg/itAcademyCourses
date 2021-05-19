package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.api.services.IUserService;
import by.azot.asutp.api.utils.IEmailSender;
import by.azot.asutp.rest.api.IControllerUrl;
import by.azot.asutp.rest.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(IControllerUrl.USERS)
public class UserController implements IControllerUrl {

    @Autowired
    private IUserService userService;

    @Autowired
    private IEmailSender emailSender;

    @GetMapping(value = PAGE)
    public ModelAndView showUsers(@PathVariable int page) {
        List<UserDto> users = userService.getUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(USERSPAGE);
        modelAndView.addObject("title", "Users:");

        Pagination<UserDto> userDtoPagination = new Pagination<UserDto>(users, page, OBJECTUSERSLIST, modelAndView);
        return userDtoPagination.getModelAndView();
    }

    @GetMapping
    public ModelAndView showUsersFirstPage() {
        return this.showUsers(1);
    }

    @GetMapping(value = FINDID)
    public ModelAndView findUser(@PathVariable Long id) {
        UserDto userDto = userService.findUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(USERPAGE);
        modelAndView.addObject(OBJECTUSER, userDto);
        return modelAndView;
    }

    @GetMapping(value = FIRSTNAME)
    public ModelAndView findUserByFirstName(@PathVariable String userName) {
        UserDto userDto = userService.findUserByUserName(userName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(USERPAGE);
        modelAndView.addObject(OBJECTUSER, userDto);
        return modelAndView;
    }

    // create user

    @GetMapping(value = ADDPAGE)
    public ModelAndView createUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(USERFORMPAGE);
        modelAndView.addObject(OBJECTUSER, new UserDto());
        modelAndView.addObject("title", "Add new user");
        return modelAndView;
    }

    @PostMapping(value = ADDPAGE)
    public String createUserSubmit(UserDto user, Model model) {
        UserDto userDto = this.userService.createUser(user);
        this.SendEmailAdmin(user);
        return REDIRECTUSERS;
    }

    //===============update=================

    @GetMapping(value = UPDATEID)
    public ModelAndView updateUser(@PathVariable(value = "id") long id) {
        UserDto userDto = userService.findUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(USERPAGEUPDATE);
        modelAndView.addObject(OBJECTUSER, userDto);
        modelAndView.addObject("title", "Update user:");
        return modelAndView;
    }

    @PostMapping(value = UPDATEID)
    public String updateUser(@PathVariable(value = "id") long id, UserDto userDto, @RequestParam(value = "file", required = false) MultipartFile file, Model model) {
        this.userService.updateUser(id, userDto, file);
        return REDIRECTUSERS;
    }

    @PostMapping(REMOVEID)
    public String deleteUserPost(@PathVariable(value = "id") long id, Model model) {
        this.userService.deleteUser(id);
        return REDIRECTUSERS;
    }

    public void SendEmailAdmin(UserDto user) {
        try {
            emailSender.sendEmailToAdmin(user, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

