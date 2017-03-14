package by.boiko.snet;


import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class NamexTweet {

    private final static String CONSUMER_KEY = "PT6uezLMteHqTsq2VO3qio3cT";
    private final static String CONSUMER_KEY_SECRET = "6TbfhDYTprrYUh5RIuL9Mml4hcbDQk9sVOWxpkZsS3SNWWkJnb";
    private final static String ACCESS_TOKEN = "2482477239-pmGBbS1CwltUJhcNuOvXDpRTB1zUvpHzvJ7Aaga";
    private final static String ACCESS_TOKEN_SECRET = "2482477239-pmGBbS1CwltUJhcNuOvXDpRTB1zUvpHzvJ7Aaga";


    public String main() throws TwitterException {

        String testStatus = "Hello from twitter4js";
        ConfigurationBuilder cb = new ConfigurationBuilder();
        //the following is set without accesstoken- desktop client
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_KEY_SECRET);

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        System.out.println("-----");
        RequestToken requestToken = twitter.getOAuthRequestToken();

        System.out.println("Got request token.");
        System.out.println("Request token: " + requestToken.getToken());
        System.out.println("Request token secret: " + requestToken.getTokenSecret());
        System.out.println("|-----");

        AccessToken accessToken = null;
        System.out.println(requestToken.getAuthorizationURL());
        return String.valueOf(requestToken.getAuthenticationURL());
    }

}

