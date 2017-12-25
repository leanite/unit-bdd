package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;


import org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest.PullRequestDataSource;
import org.bitbucket.lcleite.desafioandroid.data.mapper.PullRequestDataModelMapper;
import org.bitbucket.lcleite.desafioandroid.data.model.PullRequestDataModel;
import org.bitbucket.lcleite.desafioandroid.data.service.PullRequestRetrofitService;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.UseCaseCallback;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesMockInterceptor;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leandro on 22/12/2017.
 */

public class PullRequestDataSourceSpy implements PullRequestDataSource {

    private Retrofit retrofit;
    private PullRequestRetrofitService service;
    private PullRequestDataModelMapper pullRequestDataMapper;

    public PullRequestDataSourceSpy(Interceptor interceptor) {
        OkHttpClient client = new OkHttpClient.Builder() //FIXME: duplicated code
                .addInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        service = retrofit.create(PullRequestRetrofitService.class);
        pullRequestDataMapper = new PullRequestDataModelMapper();
    }

    @Override
    public void getPullRequests(
            Repository repository, String state, int pageNumber,
            UseCaseCallback<List<PullRequest>, GetPullRequestsOutput.ErrorData> callback) {

        String username = repository.getOwner().getUsername();
        String repositoryName = repository.getName();

        Call<List<PullRequestDataModel>> call =
                service.getPullRequests(username, repositoryName, state, pageNumber);

        try {
            Response<List<PullRequestDataModel>> response = call.execute();
            List<PullRequestDataModel> pullRequestsData = response.body();
            List<PullRequest> pullRequests = pullRequestDataMapper.toEntityList(pullRequestsData);

            callback.onSuccess(pullRequests);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAmountPullRequests(
            String repositoryUsername, String repositoryName,
            String state,
            UseCaseCallback<GetAmountPullRequestsOutput.ResponseData, GetAmountPullRequestsOutput.ErrorData> callback) {

        Call<GetAmountPullRequestsOutput.ResponseData> call =
                service.getAmountPullRequests(createQuery(repositoryUsername, repositoryName, state));

        try {
            Response<GetAmountPullRequestsOutput.ResponseData> response = call.execute();

            GetAmountPullRequestsOutput.ResponseData responseData = response.body();
            responseData.setState(PullRequest.State.valueOf(state));

            callback.onSuccess(responseData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String createQuery(String repositoryUsername, String repositoryName, String state){
        return "+type:pr+repo:"+ repositoryUsername + "/" + repositoryName + "+state:" + state;
    }
}
