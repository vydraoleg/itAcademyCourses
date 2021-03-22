package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.services.IUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private IUtilService utilService;

    @GetMapping("/")
    public String home() {
        return "mainpage";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/book")
    public ModelAndView search(@RequestParam(value = "isbn", required = false) String isbn) {
        ModelAndView modelAndView = new ModelAndView();
        utilService.getBookByIsbn(isbn);
        return modelAndView;
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
