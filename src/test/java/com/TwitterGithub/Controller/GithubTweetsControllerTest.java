package com.TwitterGithub.Controller;

import com.TwitterGithub.Model.GithubTweets;
import org.junit.Test;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by joseph.lim-effendy on 8/16/16.
 */
public class GithubTweetsControllerTest {

    private List<GithubTweets> repos;
    private GithubTweetsController githubTweetsController  = new GithubTweetsController();

    @Test
    public void searchGithubTwitter() throws Exception {
        repos = githubTweetsController.searchGithubTwitter();
        assertTrue(repos instanceof List);
        assertTrue(repos.get(0) instanceof GithubTweets);
    }


    @Test
    public void twitterTemplateTest() throws Exception {
        Twitter twitter = githubTweetsController.twitterTemplate();
        assertNotNull(twitter);
    }

    @Test
    public void repoTweetsTest() throws Exception {
        List<Tweet> tweetList = githubTweetsController.repoTweets("ReactiveKit");
        assertNotNull(tweetList);
    }

}