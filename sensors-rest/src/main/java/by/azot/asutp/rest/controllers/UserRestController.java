package by.azot.asutp.rest.controllers;

import java.util.List;

import by.azot.asutp.api.dto.UserRoleIdsDto;
import by.azot.asutp.rest.api.IControllerUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.api.services.IUserService;

@RestController
@RequestMapping(IControllerUrl.RESTUSERS)
public class UserRestController  implements IControllerUrl {

    @Autowired
    private IUserService userService;
    
    @GetMapping
    public List<UserDto> findUsers() {
        return userService.getUsers();
    }
    
    @GetMapping(value = FINDID)
    public UserDto findUser(@PathVariable Long id) {    return userService.findUser(id);
    }
    
    @GetMapping(value = FIRSTNAME)
    public UserDto findUserByFirstName(@PathVariable String firstName) {
        return userService.findUserByFirstName(firstName);
    }
    
    @PostMapping(value = UPDATEID)
    public void updateUser(@PathVariable(value = "id") long id,UserDto user, @RequestParam(value = "file", required = false) MultipartFile file) {
        this.userService.updateUser(user.getUserName(), user, file);
    }
    
    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        return this.userService.createUser(user);
    }

    @PutMapping(value = FINDID)
    public void updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        this.userService.updateUser(id, user);
    }

    @DeleteMapping(value = FINDID)
    public void deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
    }
    
    @PatchMapping()
    public void assignRoleToUser(@RequestBody UserRoleIdsDto ids) {
        this.userService.assignRoleToUser(ids);
    }

}
