package by.boiko.snet.dao;


import by.boiko.snet.model.User;

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

    void update(User user);

    List loadNames();

}
