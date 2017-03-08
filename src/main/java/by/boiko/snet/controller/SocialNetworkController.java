package by.boiko.snet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SocialNetworkController {



    @RequestMapping(value = "/social", method = RequestMethod.GET)
    public ModelAndView getSocial() {

        ModelAndView mv = new ModelAndView("twitter");
    return mv;
    }

    @RequestMapping(value = "/connect/twitter")
    public  String getSocialTwitter(Model model) {

        return "hello";
    }
}
