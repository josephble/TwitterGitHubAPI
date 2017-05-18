package com.TwitterGithub.Github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by joseph.lim-effendy on 8/4/16.
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubProject {

    private Long id;
    private String name;
    private String fullName;
    private String description;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("full_name")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("full_name")
    public void setFullName(String full_name) {
        this.fullName = full_name;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return new StringBuffer("ID : ").append(this.id).append("  Name : ").append(this.name).append(" fullName : ").append(this.fullName).append(" description : ").append(this.description).toString();
    }


}

