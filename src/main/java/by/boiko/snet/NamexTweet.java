//package by.boiko.snet;
//
//
//import twitter4j.*;
//import twitter4j.auth.AccessToken;
//
//import java.io.IOException;
//
//
//public class NamexTweet {
//
//    private final static String CONSUMER_KEY = "DXjHgk9BHPmekJ2r7OnDg";
//    private final static String CONSUMER_KEY_SECRET = "u36Xuak99M9tf9Jfms8syFjf1k2LLH9XKJTrAbftE0";
//
//    public static void main(String[] args) throws Exception {
//        new NamexTweet().start();
//
//    }
//
//    public void start() throws TwitterException, IOException {
//
//        Twitter twitter = new TwitterFactory().getInstance();
//        twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);
//        String accessToken = getSavedAccessToken();
//        String accessTokenSecret = getSavedAccessTokenSecret();
//        AccessToken oathAccessToken = new AccessToken(accessToken, accessTokenSecret);
//        twitter.setOAuthAccessToken(oathAccessToken);
//        twitter.updateStatus("Hi, im updating status again from Namex Tweet for Demo");
//        System.out.println("\nMy Timeline:");
//
//        ResponseList list = twitter.getHomeTimeline();
//
//        for (Status each : list) {
//
//            System.out.println("Sent by: @" + each.getUser().getScreenName()
//                    + " - " + each.getUser().getName() + "\n" + each.getText() + "\n");
//        }
//    }
//
//    private String getSavedAccessTokenSecret() {
//        return "oC8tImRFL6i8TuRkTEaIcWsF8oY4SL5iTGNkG9O0Q";
//
//    }
//
//    private String getSavedAccessToken() {
//        return "102333999-M4W1Jtp8y8QY8RH7OxGWbM5Len5xOeeTUuG7QfcY";
//    }
//
//}
//
