package by.boiko.snet.controller;


import by.boiko.snet.LoginTest;
import by.boiko.snet.model.TwitterInfoUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import twitter4j.TwitterException;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model){
        return "login";
    }

    @RequestMapping(value = "/current", method = RequestMethod.POST)
    @ResponseBody
    public TwitterInfoUser loginPageTwitter(LoginTest loginTest) throws TwitterException {
        return loginTest.main();
    }

}