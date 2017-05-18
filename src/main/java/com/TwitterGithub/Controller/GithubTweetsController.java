package com.TwitterGithub.Controller;

import com.TwitterGithub.Configuration.TwitterConfiguration;
import com.TwitterGithub.Github.GithubClient;
import com.TwitterGithub.Github.GithubProject;
import com.TwitterGithub.Twitter.TwitterClient;
import com.TwitterGithub.Model.GithubTweets;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.Tweet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseph.lim-effendy on 8/8/16.
 */

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class GithubTweetsController {

    @RequestMapping(method = RequestMethod.GET)
    public List<GithubTweets> searchGithubTwitter() throws IOException {
        List<GithubTweets> githubTweetsList = new ArrayList<GithubTweets>();

        GithubClient githubClient = new GithubClient();

        List<GithubProject> repos = githubClient.getGithubRepos();

        for(GithubProject proj : repos) {
            GithubTweets gtweet = new GithubTweets(proj, repoTweets(proj.getName()));
            githubTweetsList.add(gtweet);
        }
        return githubTweetsList;
    }

    public Twitter twitterTemplate() throws IOException {
        TwitterConfiguration twitterConfig = new TwitterConfiguration();
        return twitterConfig.twitterTemplate();
    }

    public List<Tweet> repoTweets(String projectName) throws IOException {
        TwitterClient twitterClient = new TwitterClient(twitterTemplate());
        return twitterClient.tweetSearch(projectName);
    }
}
