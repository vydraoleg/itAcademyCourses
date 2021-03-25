package by.azot.asutp.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.api.dto.UserPetIdsDto;
import by.azot.asutp.api.services.IUserService;

@RestController
@RequestMapping("/rest/users")
public class UserRestController {

    @Autowired
    private IUserService userService;
    
    @GetMapping
    public List<UserDto> findUsers() {
        return userService.getUsers();
    }
    
    @GetMapping(value = "/{id}")
    public UserDto findUser(@PathVariable int id) {    return userService.findUser(id);
    }
    
    @GetMapping(value = "/name/{firstName}")
    public UserDto findUserByFirstName(@PathVariable String firstName) {
        return userService.findUserByFirstName(firstName);
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
    
  //===============update=================
    
    @GetMapping(value = "/upd")
    public ModelAndView updateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersFormPageUpd");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }
    
    @PostMapping(value = "/upd")
    public void updateUser(UserDto user, @RequestParam(value = "file", required = false) MultipartFile file) {
        this.userService.updateUser(user.getUsername(), user, file);
    }
    
  //================================
    
    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUser(id);
    }
    
    @PatchMapping()
    public void assingPetToUser(@RequestBody UserPetIdsDto ids) {
        this.userService.assingPetToUser(ids);
    }

}
