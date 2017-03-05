package by.boiko.snet.service;


import by.boiko.snet.model.User;

import java.util.List;

/**
 * The interface determines the methods for work with User.
 */
public interface UserService {

    /**
     * Loads list of all users with params.
     *
     * @param offset the displacement of the first record
     * @param limit the maximum number of entries
     * @return list users
     */
    List<User> getAll(int offset, int limit);

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

    /**
     * Update a user.
     *
     * @param user user object to update
     */
    void update(User user);

    List<User> getNames();

}
