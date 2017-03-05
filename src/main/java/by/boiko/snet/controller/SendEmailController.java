package by.boiko.snet.controller;

import by.boiko.snet.email.EmailSender;
import by.boiko.snet.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SendEmailController {


    @RequestMapping(value = "/actions/send-email")
    public String sendEmail(@RequestBody Email email, EmailSender emailSender) {
        emailSender.sendEmail(email);
        return "hello";
    }
}
