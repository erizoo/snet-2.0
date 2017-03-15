package by.boiko.snet;

import by.boiko.snet.model.TwitterInfoUser;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class LoginTest {

    private final static String CONSUMER_KEY = "PT6uezLMteHqTsq2VO3qio3cT";
    private final static String CONSUMER_KEY_SECRET = "6TbfhDYTprrYUh5RIuL9Mml4hcbDQk9sVOWxpkZsS3SNWWkJnb";
    private final static String ACCESS_TOKEN = "2482477239-z801mJ3lKihVdXx7PL6qAAHYaaDc0GUMEJV7DwX";
    private final static String ACCESS_TOKEN_SECRET = "szROFGKcsUUfTIW08GLzHLzgD2XiyqdoiwMEKZOvgvpaS";


    public TwitterInfoUser main() throws TwitterException {


        String testStatus = "Hello from twitter4jsss";

        ConfigurationBuilder cb = new ConfigurationBuilder();


        //the following is set without accesstoken- desktop client
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_KEY_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);



        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        ResponseList<Status> a = twitter.getHomeTimeline(new Paging(1,1000));
        System.out.println( twitter.getScreenName());
        TwitterInfoUser tw = new TwitterInfoUser();
        tw.setNickName(twitter.getScreenName());
//        tw.setName(twitter.getPrivacyPolicy());
//        for (Status b: a){
//            long userId = b.getUser().getId();// user Id
//            String userName = b.getUser().getName(); // user name
//            String tweetText = b.getText(); // tweet

//            System.out.println(userId+" "+userName+" "+tweetText);
//        }

        return tw ;
    }
}




