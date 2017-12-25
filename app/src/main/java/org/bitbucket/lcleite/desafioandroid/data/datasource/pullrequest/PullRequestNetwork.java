package org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest;

import org.bitbucket.lcleite.desafioandroid.data.mapper.PullRequestDataModelMapper;
import org.bitbucket.lcleite.desafioandroid.data.model.PullRequestDataModel;
import org.bitbucket.lcleite.desafioandroid.data.service.PullRequestRetrofitService;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.UseCaseCallback;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsOutput;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leandro on 22/12/2017.
 */

public class PullRequestNetwork implements PullRequestDataSource{


    //FIXME: Dependency Injection
    private Retrofit retrofit;
    private PullRequestRetrofitService service;
    private PullRequestDataModelMapper pullRequestDataMapper;

    public PullRequestNetwork() {
        //TODO: Add Cache
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(PullRequestRetrofitService.class);
        pullRequestDataMapper = new PullRequestDataModelMapper();
    }

    //TODO: improve code readability
    @Override
    public void getPullRequests(
            String repositoryUsername, String repositoryName,
            String state, int pageNumber,
            final UseCaseCallback<List<PullRequest>, GetPullRequestsOutput.ErrorData> callback) {

        Call<List<PullRequestDataModel>> call =
                service.getPullRequests(repositoryUsername, repositoryName, state, pageNumber);

        call.enqueue(new Callback<List<PullRequestDataModel>>() {
            @Override
            public void onResponse(Call<List<PullRequestDataModel>> call, Response<List<PullRequestDataModel>> response) {
                List<PullRequestDataModel> pullRequestsData = response.body();
                List<PullRequest> pullRequests = pullRequestDataMapper.toEntityList(pullRequestsData);

                callback.onSuccess(pullRequests);
            }

            @Override
            public void onFailure(Call<List<PullRequestDataModel>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getAmountPullRequests(
            String repositoryUsername, String repositoryName,
            final String state,
            final UseCaseCallback<GetAmountPullRequestsOutput.ResponseData, GetAmountPullRequestsOutput.ErrorData> callback) {

        Call<GetAmountPullRequestsOutput.ResponseData> call =
                service.getAmountPullRequests(createQuery(repositoryUsername, repositoryName, state));

        call.enqueue(new Callback<GetAmountPullRequestsOutput.ResponseData>() {
            @Override
            public void onResponse(Call<GetAmountPullRequestsOutput.ResponseData> call, Response<GetAmountPullRequestsOutput.ResponseData> response) {
                GetAmountPullRequestsOutput.ResponseData responseData = response.body();

                if(responseData != null)
                    responseData.setState(PullRequest.State.valueOf(state));

                callback.onSuccess(responseData);
            }

            @Override
            public void onFailure(Call<GetAmountPullRequestsOutput.ResponseData> call, Throwable t) {}
        });
    }

    private String createQuery(String repositoryUsername, String repositoryName, String state){
        return "+type:pr+repo:"+ repositoryUsername + "/" + repositoryName + "+state:" + state;
    }
}
