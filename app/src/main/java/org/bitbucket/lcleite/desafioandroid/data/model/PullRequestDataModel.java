package org.bitbucket.lcleite.desafioandroid.data.model;

import com.google.gson.annotations.SerializedName;

import org.bitbucket.lcleite.desafioandroid.entity.User;

import java.util.Date;

/**
 * Created by leandro on 22/12/2017.
 */

public class PullRequestDataModel extends DataModel{

    @SerializedName("user")
    private UserDataModel creator;

    @SerializedName("title")
    private String title;

    @SerializedName("status")
    private String status;

    @SerializedName("body")
    private String body;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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
