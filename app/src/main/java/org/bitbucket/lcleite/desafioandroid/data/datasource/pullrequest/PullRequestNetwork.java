package org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest;

import org.bitbucket.lcleite.desafioandroid.data.datasource.repository.RepositoryDataSource;
import org.bitbucket.lcleite.desafioandroid.data.service.PullRequestRetrofitService;
import org.bitbucket.lcleite.desafioandroid.data.service.RepositoryRetrofitService;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesOutput;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leandro on 22/12/2017.
 */

public class PullRequestNetwork implements PullRequestDataSource{

    //FIXME: Dependency Injection

    private Retrofit retrofit;
    private PullRequestRetrofitService service;

    public PullRequestNetwork() {
        //TODO: Add Cache
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(PullRequestRetrofitService.class);
    }

    @Override
    public void getPullRequests(Repository repository, String state, int pageNumber, Callback<GetPullRequestsOutput.ResponseData> callback) {
        Call<GetPullRequestsOutput.ResponseData> call =
                service.getPullRequests(repository.getOwner().getUsername(), repository.getName(), state, pageNumber);

        call.enqueue(callback);
    }
}
