package org.bitbucket.lcleite.desafioandroid.entity;

import java.util.Date;
import java.util.Objects;

/**
 * Created by leandro on 22/12/2017.
 */

public class PullRequest extends Entity{

    public enum State{
        open("open"), closed("closed");

        private final String value;

        State(String value){ this.value = value; }

        public String value() { return value; }
    }

    private User creator;
    private String title;
    private boolean open;
    private String body;
    private String url;
    private Date createdAt;
    private boolean merged;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isMerged() {
        return merged;
    }

    public void setMerged(boolean merged) {
        this.merged = merged;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        PullRequest pullRequest = (PullRequest) other;
        return open == pullRequest.open &&
                merged == pullRequest.merged &&
                Objects.equals(creator, pullRequest.creator) &&
                Objects.equals(title, pullRequest.title) &&
                Objects.equals(body, pullRequest.body) &&
                Objects.equals(createdAt, pullRequest.createdAt);
    }
}
