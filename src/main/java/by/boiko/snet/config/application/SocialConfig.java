package by.boiko.snet.config.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.inject.Inject;
import javax.sql.DataSource;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class SocialConfig {

    @Inject
    private Environment environment;

    @Inject
    private DataSource dataSource;


//    @Bean
//    @Scope(value = "singleton", proxyMode = ScopedProxyMode.INTERFACES)
//    public ConnectionFactoryLocator connectionFactoryLocator() {
//        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
//        registry.addConnectionFactory(new TwitterConnectionFactory(environment.getProperty("spring.social.twitter.appId"),
//                environment.getProperty("spring.social.twitter.appSecret")));
//
//        return registry;
//    }
//
//
//    @Bean
//    @Scope(value = "singleton", proxyMode = ScopedProxyMode.INTERFACES)
//    public UsersConnectionRepository usersConnectionRepository() {
//        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(), Encryptors.noOpText());
//    }
//
//    @Bean
//    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
//    public ConnectionRepository connectionRepository() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null) {
//            throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
//        }
//        return usersConnectionRepository().createConnectionRepository(authentication.getName());
//    }
//
//    @Bean
//    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
//    public Twitter twitter() {
//        Connection<Twitter> twitter = connectionRepository().findPrimaryConnection(Twitter.class);
//        return twitter != null ? twitter.getApi() : null;
//    }

}