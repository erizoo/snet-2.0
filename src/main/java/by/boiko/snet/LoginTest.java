package by.boiko.snet;

public class LoginTest {

    private final static String CONSUMER_KEY = "PT6uezLMteHqTsq2VO3qio3cT";
    private final static String CONSUMER_KEY_SECRET = "6TbfhDYTprrYUh5RIuL9Mml4hcbDQk9sVOWxpkZsS3SNWWkJnb";
    private final static String ACCESS_TOKEN = "2482477239-z801mJ3lKihVdXx7PL6qAAHYaaDc0GUMEJV7DwX";
    private final static String ACCESS_TOKEN_SECRET = "szROFGKcsUUfTIW08GLzHLzgD2XiyqdoiwMEKZOvgvpaS";
    private final static String CLIENT_ID = "0e37d7d0c3534a14a6d8448cdf5cef71";
    private final static String REDIRECT_URI = "https://snet2.herokuapp.com/users";


    public String main(){

        String URL = "https://api.instagram.com/oauth/authorize/?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&response_type=code";
        String step2 = "https://api.instagram.com/oauth/access_token?client_id=0e37d7d0c3534a14a6d8448cdf5cef71?client_secret=629b16ba96a44b8db7ad34bbb54344aa?redirect_uri=https://snet2.herokuapp.com/users?code=39967885c1c444c989fb03bf2be39b05";
        return URL ;
    }
}




