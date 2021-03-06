package by.boiko.snet.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasRole('USER')")
public class AppController {

    @RequestMapping("/")
    public String hello(){

        return "login";
    }

    @RequestMapping("/error")
    public String error(Model model){
        model.addAttribute("error", "Oops! A 404 error happened because the resource could not be found.");
        return "error";
    }

}