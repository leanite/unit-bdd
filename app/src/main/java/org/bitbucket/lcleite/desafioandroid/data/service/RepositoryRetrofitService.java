package org.bitbucket.lcleite.desafioandroid.data.service;

import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesOutput;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by leandro on 22/12/2017.
 */

public interface RepositoryRetrofitService {

    @GET("search/repositories?q=language:Java&sort=stars")
    Call<GetRepositoriesOutput.ResponseData> getRepositoriesAtPageNumber(@Query("page") int pageNumber);
}
