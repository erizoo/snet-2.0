package by.boiko.snet.service;


import by.boiko.snet.model.User;

import java.time.LocalDateTime;
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

    /**
     * Get list of all users.
     *
     * @return list users
     */
    List<User> getAll();

    /**
     * Get creation date a user.
     *
     * @param id identifier of a user
     * @return creation date a user
     */
    LocalDateTime getCreatedDate(int id);

    /**
     * Get a recording with parameter offset.
     *
     * @param offset params for search emails
     * @return list users
     */
    List<User> getAllWithOffset(Integer offset);

    /**
     * Get a recording with parameter limit.
     *
     * @param limit params for search emails
     * @return list users
     */
    List<User> getAllWithLimit(Integer limit);

    List<User> getAllWithInc(String s);
}
