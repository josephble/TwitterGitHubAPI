package com.TwitterGithub.Github;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/**
 * Created by joseph.lim-effendy on 8/4/16.
 */
@Component
public class GithubClient {
    private static final String GITHUB_REPO = "reactive";
    private static final String GITHUB_SEARCH_REPO_URI = "https://api.github.com/search/repositories?q=";

    //Calls the Github request and casts it to a RestTemplate that can parse it into a List of GithubProjects
    public List<GithubProject> getGithubRepos() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(GITHUB_SEARCH_REPO_URI + GITHUB_REPO, GithubResponseInfo.class).getItems();
    }
}
