package eu.it.academy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import eu.it.academy.api.services.IUserService;
import eu.it.academy.entities.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;
    
    @GetMapping(value = "/{id}")
    public User findUser(@PathVariable int id) {
        return userService.findUser(id);
    }

    @PostMapping
    public User createUser(@PathVariable int id) {
        return userService.findUser(id);
    }
}
