package by.boiko.snet.dao;


import by.boiko.snet.model.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The interface determines the basic methods of access to the database.
 */
public interface UserDao {

    /**
     * Loads list of all users from storage.
     *
     * @param offset the displacement of the first record
     * @param limit the maximum number of entries
     * @return list all users
     */
    List<User> loadAll(int offset, int limit);

    /**
     * Deletes a user from a storage by id.
     *
     * @param id identifier of a user to delete
     */
    void delete(int id);

    /**
     * Saves a user into a storage.
     *
     * @param user user object to save
     */
    void save(User user);

    /**
     * Loads a user from a storage by id.
     *
     * @param id identifier of a user
     * @return a user
     */
    User loadAllUsersForId(int id);

    /**
     * Update a user in a storage.
     *
     * @param user model user
     */
    void update(User user);

    /**
     * Loads a users from a storage by name.
     *
     * @return list users
     */
    List loadNames();

    /**
     * Loads list of all users from storage.
     *
     * @return list users
     */
    List<User> loadAll();

    /**
     * Load creation date a user.
     *
     * @param id identifier of a user
     * @return creation date a user
     */
    LocalDateTime getCreatedDate(int id);

    /**
     * Load a recording with parameter limit.
     *
     * @param offset params for search users
     * @return list users
     */
    List<User> loadAllWithOffset(Integer offset);

    /**
     * Load a recording with parameter limit.
     *
     * @param limit params for search users
     * @return list users
     */
    List<User> loadAllWithLimit(Integer limit);

    /**
     * Load a recording with parameter inc.
     *
     * @param inc param
     * @return list users
     */
    List<User> loadAllWithInc(String inc);

    /**
     * Load a recording with parameter exc.
     *
     * @param exc param
     * @return list users
     */
    List<User> loadAllWithExc(String exc);
}
