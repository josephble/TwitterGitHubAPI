package com.TwitterGithub.Github;

import com.TwitterGithub.Configuration.TwitterConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by joseph.lim-effendy on 8/15/16.
 */
public class GithubClientTest {

    List<GithubProject> githubProjectList;

    @Before
    public void setUp() throws Exception {
        GithubClient githubClient = new GithubClient();
        githubProjectList = githubClient.getGithubRepos();
    }


    @Test
    public void getGithubRepos() throws Exception {
        assertTrue(githubProjectList instanceof List);
        assertTrue(githubProjectList.get(0) instanceof GithubProject);
    }

}