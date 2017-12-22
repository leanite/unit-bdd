package org.bitbucket.lcleite.desafioandroid.entity;

import java.util.Objects;

/**
 * Created by leandro on 22/12/2017.
 */

public class User extends Entity{

    private String username;
    private String name;
    private String avatarUrl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public final boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        User user = (User) other;
        return Objects.equals(username, user.username) &&
                Objects.equals(name, user.name) &&
                Objects.equals(avatarUrl, user.avatarUrl);
    }
}
