package org.bitbucket.lcleite.desafioandroid.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by leandro on 22/12/2017.
 */

public class PullRequestDataModel extends DataModel{

    @SerializedName("user")
    private UserDataModel creator;

    @SerializedName("title")
    private String title;

    @SerializedName("state")
    private String state;

    @SerializedName("body")
    private String body;

    @SerializedName("html_url")
    private String url;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("merged_at")
    private String mergedAt;

    public UserDataModel getCreator() {
        return creator;
    }

    public void setCreator(UserDataModel creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getMergedAt() {
        return mergedAt;
    }

    public void setMergedAt(String mergedAt) {
        this.mergedAt = mergedAt;
    }
}
