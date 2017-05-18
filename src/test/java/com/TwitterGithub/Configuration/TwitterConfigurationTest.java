package com.TwitterGithub.Configuration;

import com.TwitterGithub.Twitter.TwitterClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.social.twitter.api.Twitter;

import static org.junit.Assert.*;

/**
 * Created by joseph.lim-effendy on 8/15/16.
 */
public class TwitterConfigurationTest {

    private Twitter twitter;
    private TwitterConfiguration twitterConfiguration;

    @Before
    public void setUp() throws Exception {
        twitterConfiguration = new TwitterConfiguration();
        twitter = twitterConfiguration.twitterTemplate();
    }

    @Test
    public void twitterTemplateTest() throws Exception {
        assertTrue(twitter instanceof Twitter);

    }

    @Test
    public void setTwitterCredsTest() throws Exception {
        assertNotNull(twitterConfiguration.getAccessSecret());
        assertNotNull(twitterConfiguration.getAccessToken());
        assertNotNull(twitterConfiguration.getConsumerKey());
        assertNotNull(twitterConfiguration.getConsumerSecret());
    }
}