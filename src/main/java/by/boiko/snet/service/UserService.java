package by.boiko.snet.service;


import by.boiko.snet.model.User;

import java.util.List;

/**
 * The interface determines the methods for work with User.
 */
public interface UserService {

    /**
     * Loads list of all users.
     *
     * @return list of users
     */
    List<User> getAll();

    /**
     * Loads a user by id.
     *
     * @param id identifier of a user
     * @return a user
     */
    User getAllForId(int id);

    /**
     * Deletes a user by id.
     *
     * @param id identifier of a user
     */
    void delete(int id);

    /**
     * Saves a user.
     *
     * @param user user object to save
     */
    void save(User user);

    void update(User user);

    List<User> getNames();
}
