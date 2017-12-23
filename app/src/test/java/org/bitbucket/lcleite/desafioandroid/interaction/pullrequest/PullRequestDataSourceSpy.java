package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;


import org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest.PullRequestDataSource;
import org.bitbucket.lcleite.desafioandroid.data.model.PullRequestDataModel;
import org.bitbucket.lcleite.desafioandroid.data.service.PullRequestRetrofitService;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesMockInterceptor;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leandro on 22/12/2017.
 */

public class PullRequestDataSourceSpy implements PullRequestDataSource {

    private Retrofit retrofit;
    private PullRequestRetrofitService service;

    public PullRequestDataSourceSpy(String state) {
        OkHttpClient client = new OkHttpClient.Builder() //FIXME: duplicated code
                .addInterceptor(new GetPullRequestsMockInterceptor(state))
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        service = retrofit.create(PullRequestRetrofitService.class);
    }

    @Override
    public void getPullRequests(Repository repository, String state, int pageNumber, Callback<List<PullRequestDataModel>> callback) {
        String username = repository.getOwner().getUsername();
        String repositoryName = repository.getName();

        Call<List<PullRequestDataModel>> call =
                service.getPullRequests(username, repositoryName, state, pageNumber);

        try {
            callback.onResponse(call, call.execute());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
