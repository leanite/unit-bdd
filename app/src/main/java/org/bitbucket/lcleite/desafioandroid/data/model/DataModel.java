package org.bitbucket.lcleite.desafioandroid.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by leandro on 22/12/2017.
 */

public abstract class DataModel {

    @SerializedName("id")
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
