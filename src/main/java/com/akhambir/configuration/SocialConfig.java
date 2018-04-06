package com.akhambir.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

@EnableSocial
@Configuration
public class SocialConfig implements SocialConfigurer {


    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
        cfConfig.addConnectionFactory(new FacebookConnectionFactory(
                env.getProperty("facebook.clientId"),
                env.getProperty("facebook.clientSecret")));
    }

    @Override
    public UserIdSource getUserIdSource() {
        return () -> "";
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return new InMemoryUsersConnectionRepository(connectionFactoryLocator);
    }

    /*@Bean
    @Scope(value="request", proxyMode= ScopedProxyMode.INTERFACES)
    public Facebook facebook(ConnectionRepository repository) {
        Connection<Facebook> connection = repository.findPrimaryConnection(Facebook.class);
        return connection != null ? connection.getApi() : null;
    }*/


    @Bean
    public Facebook facebookTemplate(Environment env) {
        return new FacebookTemplate(
                env.getProperty("access.token"),
                env.getProperty("app.name"));
    }

    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }

    //new FacebookTemplate("EAAcBEGmZA98QBAGFuPZBl9Cr12yFPLVXWHDkf5vNcRmMsykZArc0BNmZCxyk4azqp3FLXtiCTzSKNgLFiRTHdfcGGO5j3UZA6oQ8qJ9Md6tFC4fU4vNpiiGtxTlFVbngqeQeGqySugDCG5BOkRNUbc53qCZCtXmffLfZBsG9YhXqz7sVMgyY3IJRIQK0sBZCZC2vax1alZC9JyaAZDZD", "akhambir");
}
