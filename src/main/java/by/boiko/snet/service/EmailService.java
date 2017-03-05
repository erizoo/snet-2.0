package by.boiko.snet.service;

import by.boiko.snet.model.Email;

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

    /**
     * Get list of all emails.
     *
     * @return list of emails
     */
    List<Email> getAll();

    /**
     * Get list of all emails for pdf.
     *
     * @return list of emails
     */
    List<Email> getNames();
}