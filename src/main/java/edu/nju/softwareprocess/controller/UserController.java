package edu.nju.softwareprocess.controller;

import edu.nju.softwareprocess.entity.User;
import edu.nju.softwareprocess.rest.RestResultResponse;
import edu.nju.softwareprocess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Jerry Wang on 06/12/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        if(user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("Parameter 'name' must not be null or empty");
        }
        if(user.getEmail() == null) {
            throw new IllegalArgumentException("Parameter 'age' must not be null or empty");
        }
        return userService.addUser(user);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public User updateUser(@PathVariable("id") String id, @RequestBody User user) {
        if(user.getName() == null && user.getEmail() == null) {
            throw new IllegalArgumentException("Parameter 'name' and 'age' must not both be null");
        }
        return userService.addUser(user);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public RestResultResponse deleteUser(@PathVariable("id") Long id) {
        try {
            userService.deleteUser(id);
            return new RestResultResponse(true);
        } catch(Exception e) {
            return new RestResultResponse(false, e.getMessage());
        }
    }


}
