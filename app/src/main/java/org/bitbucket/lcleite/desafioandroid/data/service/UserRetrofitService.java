package org.bitbucket.lcleite.desafioandroid.data.service;

import org.bitbucket.lcleite.desafioandroid.data.model.UserDataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by leandro on 26/12/2017.
 */

public interface UserRetrofitService {

    @GET("users/{username}")
    Call<UserDataModel> getUserDetails(@Path("username") String username);
}
