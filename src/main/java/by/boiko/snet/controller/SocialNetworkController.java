package by.boiko.snet.controller;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
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
        String consumerKey = "PT6uezLMteHqTsq2VO3qio3cT"; // The application's consumer key
        String consumerSecret = "6TbfhDYTprrYUh5RIuL9Mml4hcbDQk9sVOWxpkZsS3SNWWkJnb"; // The application's consumer secret
        String accessToken = "2482477239-35NisVLe0kLFFdgoFviwvgv0KMoYlHPWqpAqPAZ"; // The access token granted after OAuth authorization
        String accessTokenSecret = "LGI5w4WPeqEjNJSUbZRVuQz6IJY2t3oZhbyUoebu1Gpj7"; // The access token secret granted after OAuth authorization
        Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        TwitterProfile profile = twitter.userOperations().getUserProfile();
        model.addAttribute("twitterProfile", profile);
        return "hello";
    }
}
