package by.boiko.snet.controller;

import by.boiko.snet.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SendEmailController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/actions/send-email")
    public String sendEmail(@RequestBody Email email) {
        email.setBody("Спасибо, ребята, вы такие классные!");
        email.setSubject("Благодарность");
        email.setFrom("alexboiko1993@gmail.com");
//
//        // takes input from e-mail form
//        String recipientAddress = request.getParameter("recipient");
//        String subject = request.getParameter("subject");
//        String message = request.getParameter("message");
//
//        // prints debug info
//        System.out.println("To: " + recipientAddress);
//        System.out.println("Subject: " + subject);
//        System.out.println("Message: " + message);

        // creates a simple e-mail object
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email.getFrom());
        mail.setSubject(email.getSubject());
        mail.setText(email.getBody());

        // sends the e-mail
        mailSender.send(mail);
        return "hello";
    }
}
