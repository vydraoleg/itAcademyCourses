package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.api.services.IUserService;
import by.azot.asutp.utils.mail.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping
    public ModelAndView findUsers() {
        List<UserDto> users = userService.getUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersPage");
        modelAndView.addObject("title", "My Users:");
        modelAndView.addObject("usersList", users);
        return modelAndView;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView findUser(@PathVariable Long id) {
        UserDto user = userService.findUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping(value = "/name/{firstName}")
    public ModelAndView findUserByFirstName(@PathVariable String firstName) {
        UserDto user = userService.findUserByFirstName(firstName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    //===============create=================

    @GetMapping(value = "/add")
    public ModelAndView createUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersFormPage");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public UserDto createUserSubmit(UserDto user) {
        return this.userService.createUser(user);
    }

/*    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        BlogPost blogPost = blogPostRepository.findById(id).orElseThrow();
        blogPost.setTitle(title);
        blogPost.setAnons(anons);
        blogPost.setFull_text(full_text);
        blogPostRepository.save(blogPost);
        return "redirect:/blog";
    }
*/


    //===============update=================

    @GetMapping(value = "/upd")
    public ModelAndView updateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersFormPageUpd");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }

    @PostMapping(value = "/upd")
    public String updateUser(UserDto user, @RequestParam(value = "file", required = false) MultipartFile file, Model model) {
        this.userService.updateUser(user.getUsername(), user, file);
        return "redirect:/";
    }

    @GetMapping(value = "/mail")
    public void SendEmailAdmin(UserDto user) throws Exception {
        EmailSender myMailSender = new EmailSender() ;
        myMailSender.sendEmailToAdmin(user,1);
    }

}
