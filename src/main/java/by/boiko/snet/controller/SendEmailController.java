package by.boiko.snet.controller;

import by.boiko.snet.email.EmailSender;
import by.boiko.snet.model.Email;
import by.boiko.snet.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

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
    @RequestMapping(value = "/actions/send-email")
    public String sendEmail(@RequestBody Email email, EmailSender emailSender) {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        emailSender.sendEmail(email);
//        email.setTime(localDateTime);
        emailService.saveEmails(email);
        return "hello";
    }
}
