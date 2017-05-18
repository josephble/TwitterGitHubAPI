package com.TwitterGithub.Model;

import java.util.List;


import com.TwitterGithub.Github.GithubProject;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.twitter.api.Tweet;

/**
 * Created by joseph.lim-effendy on 8/8/16.
 */
public class GithubTweets {
    private GithubProject github;
    private List<Tweet> tweetList;

    public GithubTweets(GithubProject github, List<Tweet> tweetList) {
        this.github = github;
        this.tweetList = tweetList;
    }

    @JsonProperty("github_repo")
    public GithubProject getGithub() {
        return github;
    }

    @JsonProperty("github_repo")
    public void setGithub(GithubProject github) {
        this.github = github;
    }

    @JsonProperty("tweets")
    public List<Tweet> getTweets() {
        return tweetList;
    }

    @JsonProperty("tweets")
    public void setTweets(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }
}