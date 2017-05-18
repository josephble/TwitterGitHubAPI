package com.TwitterGithub.Github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Created by joseph.lim-effendy on 8/7/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubResponseInfo {

    private List<GithubProject> items;

    @JsonProperty("items")
    public List<GithubProject> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<GithubProject> items) {
        this.items = items;
    }

}
