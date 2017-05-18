package com.TwitterGithub.Twitter;

import com.TwitterGithub.Configuration.TwitterConfiguration;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.Tweet;
import java.util.List;

/**
 * Created by joseph.lim-effendy on 8/14/16.
 */
public class TwitterClientTest {

    private List<Tweet> tweets;

    @Before
    public void setUp() throws Exception {
        TwitterConfiguration twitterConfiguration = new TwitterConfiguration();
        Twitter twitter = twitterConfiguration.twitterTemplate();
        TwitterClient twitterClient = new TwitterClient(twitter);
        tweets = twitterClient.tweetSearch("ReactiveKit");
    }

    @Test
    public void tweetsTest() throws Exception {
        //tests that a tweet is returned
        assertTrue(tweets instanceof List);
        assertTrue(tweets.get(0) instanceof Tweet);
    }

    @Test
    public void tweetsNoGreaterThan10Test() throws Exception {
        //tests that # of tweets returned no greater than 10
        assertFalse(tweets.size() > 10);
    }

}