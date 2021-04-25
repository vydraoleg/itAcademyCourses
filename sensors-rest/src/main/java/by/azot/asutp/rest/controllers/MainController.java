package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.services.IUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private IUtilService utilService;

    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/error")
    public String errorAll() {
        return "/error/403";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/405")
    public String error405() {
        return "/error/403";
    }

    @GetMapping("/505")
    public String error505() {
        return "/error/403";
    }

//    public ModelAndView search(@RequestParam(value = "isbn", required = false) String isbn) {
    @GetMapping("/book/{isbn}")
    public ModelAndView searchBook(@PathVariable String isbn) {
        ModelAndView modelAndView = new ModelAndView();
        utilService.getBookByIsbn(isbn);
        return modelAndView;
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
