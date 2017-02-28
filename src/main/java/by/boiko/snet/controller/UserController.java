package by.boiko.snet.controller;


import by.boiko.snet.model.User;
import by.boiko.snet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * The controller determines methods for access to User service.
 */

//@CrossOrigin(origins = "https://serene-wave-27221.herokuapp.com", maxAge = 3600)
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Returns list of all users.
     *
     * @return list of users
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAll();
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)//TODO сделать проверку на id и 404
    @ResponseBody
    public User getStudent(@PathVariable("id") int id, @RequestBody User user, HttpServletResponse response) {
        user.setId(id);
        userService.update(user);
        response.setHeader("Access-Control-Allow-Headers",  "Content-Type");
        return userService.getAllForId(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET) //TODO  404
    @ResponseBody
    public User getStudent(@PathVariable("id") int id) {
        userService.getAllForId(id);
        if (userService.getAllForId(id) == null){
            throw new RuntimeException("User with id does not exist");
        } else
        return userService.getAllForId(id);
    }

    /**
     * Deletes a user by identifier.
     *
     * @param userId identifier of a user to delete
     * @return refresh the page
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)//TODO  404
    @ResponseBody
    public List<User> deleteUser(@PathVariable("userId") int userId) {
        userService.getAllForId(userId);
        if (userService.getAllForId(userId) == null){
            throw new RuntimeException("User with id does not exist");
        } else
        userService.delete(userId);
        return userService.getAll();
    }

    /**
     * Save a new user.
     *
     * @return to page with all users
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)//TODO сделать проверку на id и 404
    @ResponseBody
    public List<User> saveUser(@RequestBody User user) {
        userService.save(user);
        return userService.getAll();
    }

}
