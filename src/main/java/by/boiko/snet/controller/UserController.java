package by.boiko.snet.controller;


import by.boiko.snet.StringSplit;
import by.boiko.snet.model.User;
import by.boiko.snet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

/**
 * The controller determines methods for access to User service.
 */

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
    public List<User> getAllUsers(@RequestParam(value = "exc", required = false) String exc, StringSplit stringSplit) {
        StringBuilder builder = new StringBuilder() ;
        StringBuilder builder1 = new StringBuilder() ;
        String us = "u.";
        String str = stringSplit.stringSplit(exc);
        String b = str.replaceAll(" ", "");
        System.out.println(b);
        builder1.append(b);
        String s = builder1.substring(1, builder1.length()-1);

        for (String constraint : s.split(",")) {
            builder.append(us);
            builder.append(constraint += ", ");
        }
        String s3 = builder.substring(0, builder.length()-1);
        System.out.println(s3);


//        System.out.println(builder);
//        String s = builder.substring(0, builder.length()-1);
//        System.out.println(s);
//        if (inc.equals("")){
//            if (offset != null && limit == null) {
//                return userService.getAllWithOffset(offset);
//            }
//            if (limit != null && offset == null) {
//                return userService.getAllWithLimit(limit);
//            }
//            if (offset == null && limit == null) {
//                return userService.getAll();
//            } else {
//                return userService.getAll(offset, limit);
//            }
//        }
        return userService.getAll();
    }

    /**
     * Update a user for id.
     *
     * @param id   identifier of a user
     * @param user model
     * @return json with find user
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public User getStudent(@PathVariable("id") int id, @RequestBody User user) {

        LocalDateTime localDateTime = LocalDateTime.now();
        user.setModifiedTimestamp(localDateTime);
        user.setId(id);
        user.setCreatedTimestamp(userService.getCreatedDate(id));
        userService.update(user);
        return userService.getAllForId(id);
    }

    /**
     * Get a user for id.
     *
     * @param id identifier of a user
     * @return json with one user
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getStudent(@PathVariable("id") int id) {
        userService.getAllForId(id);
        if (userService.getAllForId(id) == null) {
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
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public List<User> deleteUser(@PathVariable("userId") int userId) {
        userService.getAllForId(userId);
        if (userService.getAllForId(userId) == null) {
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
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public List<User> saveUser(@RequestBody User user) {
        LocalDateTime localDateTime = LocalDateTime.now();
        user.setCreatedTimestamp(localDateTime);
        userService.save(user);
        return userService.getAll();
    }

}
