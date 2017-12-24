package org.bitbucket.lcleite.desafioandroid.data.service;

import org.bitbucket.lcleite.desafioandroid.data.model.PullRequestDataModel;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsOutput;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by leandro on 24/12/2017.
 */

public interface PullRequestRetrofitService {

    @GET("repos/{username}/{repositoryName}/pulls?")
    Call<List<PullRequestDataModel>> getPullRequests(
            @Path("username") String username,
            @Path("repositoryName") String repositoryName,
            @Query("state") String state,
            @Query("page") int pageNumber);

    @GET("search/issues?")
    Call<GetAmountPullRequestsOutput.ResponseData> getAmountPullRequests(
            @Query(value = "q", encoded = true) String query);
}
