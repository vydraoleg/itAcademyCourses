package by.azot.asutp.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public UserDto findUser(@PathVariable Long id) {    return userService.findUser(id);
    }
    
    @GetMapping(value = "/name/{firstName}")
    public UserDto findUserByFirstName(@PathVariable String firstName) {
        return userService.findUserByFirstName(firstName);
    }
    
    @PostMapping(value = "/upd")
    public void updateUser(UserDto user, @RequestParam(value = "file", required = false) MultipartFile file) {
        this.userService.updateUser(user.getUsername(), user, file);
    }
    
  //================================

    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        return this.userService.createUser(user);
    }

    @PutMapping(value = "/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        this.userService.updateUser(id, user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
    }
    
    @PatchMapping()
    public void assingPetToUser(@RequestBody UserPetIdsDto ids) {
        this.userService.assingPetToUser(ids);
    }

}
