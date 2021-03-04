package eu.it.academy.rest;

import eu.it.academy.api.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model){
        return "mainpage";
    }

    @PostMapping
    public String createUser(@RequestBody UserDto user, Model model) {
        return "index"; //this.userService.createUser(user);
    }




    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/403")
    public String error403(){
        return "/error/403";
    }
}
