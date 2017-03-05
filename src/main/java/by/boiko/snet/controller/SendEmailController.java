package by.boiko.snet.controller;

import by.boiko.snet.email.EmailSender;
import by.boiko.snet.model.Email;
import by.boiko.snet.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The controller determines methods for access to Email service.
 */
@Controller
public class SendEmailController {

    @Autowired
    private EmailService emailService;

    /**
     * Save a new email.
     *
     * @return to page "hello"
     */
    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public String sendEmail(@RequestBody Email email, EmailSender emailSender) {
        LocalDateTime localDateTime = LocalDateTime.now();
        emailSender.sendEmail(email);
        email.setCreatedTimestamp(localDateTime);
        emailService.saveEmails(email);
        return "hello";
    }

    /**
     * Get information of emails.
     *
     * @return json with information
     */
    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    @ResponseBody
    public List<Email> getAllInformationOfEmails() {
        return emailService.getAll();
    }
}
