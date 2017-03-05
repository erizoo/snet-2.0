package by.boiko.snet.dao;


import by.boiko.snet.model.Email;

import java.util.List;

/**
 * The interface determines the basic methods of access to the database.
 */
public interface EmailDao {

    /**
     * Saves a email information into a storage.
     *
     * @param email email object to save
     */
    void save(Email email);

    /**
     * Loads list of all emails from storage.
     *
     * @return list of emails
     */
    List<Email> loadAll();
}
