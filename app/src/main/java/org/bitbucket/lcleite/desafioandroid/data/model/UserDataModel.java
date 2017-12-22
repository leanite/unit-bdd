package org.bitbucket.lcleite.desafioandroid.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by leandro on 22/12/2017.
 */

public class UserDataModel {

    @SerializedName("login")
    private String username;

    @SerializedName("name") //FIXME: https://api.github.com/users/ReactiveX
    private String name;

    @SerializedName("avatar_url")
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
}
