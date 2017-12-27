package org.bitbucket.lcleite.desafioandroid.data.service;

import org.bitbucket.lcleite.desafioandroid.data.model.RepositoryDataModel;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.userrepository.GetUserRepositoriesOutput;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by leandro on 22/12/2017.
 */

public interface RepositoryRetrofitService {

    @GET("search/repositories?q=language:Java&sort=stars")
    Call<GetRepositoriesOutput.ResponseData> getRepositoriesAtPageNumber(@Query("page") int pageNumber);

    @GET("users/{username}/repos?")
    Call<List<RepositoryDataModel>>
        getUserRepositoriesAtPageNumber(@Path("username") String username, @Query("page") int pageNumber);
}
