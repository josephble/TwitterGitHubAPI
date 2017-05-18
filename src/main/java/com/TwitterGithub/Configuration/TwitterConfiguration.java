package com.TwitterGithub.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Created by joseph.lim-effendy on 8/9/16.
 * Pulls data from the application.properties file and creates an instance of a TwitterTemplate
 * Note: Attempted to inject via @Value and @PropertySource, but wasn't successful
 */

@Configuration
public class TwitterConfiguration {

    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String accessTokenSecret;
    private InputStream inputStream;

    @Bean
    public Twitter twitterTemplate() throws IOException {
        establishTwitterCreds();
        Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        return twitter;
    }

    public void establishTwitterCreds() throws IOException {

        try {
            Properties property = new Properties();
            String appPropFile = "application.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(appPropFile);

            if (inputStream != null) {
                property.load(inputStream);
            } else {
                throw new FileNotFoundException("Application property file '" + appPropFile + "' not in the classpath.");
            }

            //Set details from application.properties file
            consumerKey = property.getProperty("twitter.consumerKey");
            consumerSecret = property.getProperty("twitter.consumerSecret");
            accessToken = property.getProperty("twitter.accessToken");
            accessTokenSecret = property.getProperty("twitter.accessTokenSecret");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccessSecret() {
        return accessTokenSecret;
    }

}