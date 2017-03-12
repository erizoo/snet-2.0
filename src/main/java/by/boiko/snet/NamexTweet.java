package by.boiko.snet;


import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class NamexTweet {

    private final static String CONSUMER_KEY = "PT6uezLMteHqTsq2VO3qio3cT";
    private final static String CONSUMER_KEY_SECRET = "6TbfhDYTprrYUh5RIuL9Mml4hcbDQk9sVOWxpkZsS3SNWWkJnb";
    private final static String ACCESS_TOKEN = "2482477239-pmGBbS1CwltUJhcNuOvXDpRTB1zUvpHzvJ7Aaga";
    private final static String ACCESS_TOKEN_SECRET = "2482477239-pmGBbS1CwltUJhcNuOvXDpRTB1zUvpHzvJ7Aaga";

    public static void main(String[] args) throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_KEY_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
        Twitter twitter = TwitterFactory.getSingleton();
        String message="\"A Visit to Transylvania\" by Euromaxx: Lifestyle Europe (DW) \n http://bit.ly/1cHB7MH";
        Status status = twitter.updateStatus(message);

    }

}

