package com.TwitterGithub.Twitter;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.stereotype.Component;
import java.util.List;


/**
 * Created by joseph.lim-effendy on 8/7/16.
 * Utitlizes Spring Social to search twitter
 */
@Component
public class TwitterClient {

    private static final int PAGE_SIZE = 10;
    private Twitter twitter;

    public TwitterClient (Twitter twitter) {
        this.twitter = twitter;
    }

    public List<Tweet> tweetSearch(String searchString) {
        SearchResults results = twitter.searchOperations().search(searchString, PAGE_SIZE);
        return results.getTweets();
    }
}
