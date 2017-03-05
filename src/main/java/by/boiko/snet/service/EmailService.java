package by.boiko.snet.service;

import by.boiko.snet.model.Email;
import by.boiko.snet.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface determines the methods for work with Email.
 */

public interface EmailService {

    /**
     * Save all e-mails.
     *
     */
    void saveEmails(Email email);

}