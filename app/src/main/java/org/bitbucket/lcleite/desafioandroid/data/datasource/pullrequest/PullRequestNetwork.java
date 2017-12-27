package org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest;

import org.bitbucket.lcleite.desafioandroid.data.mapper.PullRequestDataModelMapper;
import org.bitbucket.lcleite.desafioandroid.data.model.PullRequestDataModel;
import org.bitbucket.lcleite.desafioandroid.data.service.PullRequestRetrofitService;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.UseCaseCallback;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.utils.ErrorHandler;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by leandro on 22/12/2017.
 */

public class PullRequestNetwork implements PullRequestDataSource{

    private PullRequestRetrofitService service;
    private PullRequestDataModelMapper pullRequestDataMapper;

    public PullRequestNetwork(Retrofit retrofit) {
        service = retrofit.create(PullRequestRetrofitService.class);
        pullRequestDataMapper = new PullRequestDataModelMapper();
    }

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
                GetPullRequestsOutput.ErrorData errorData = new GetPullRequestsOutput.ErrorData();

                errorData.setMessage(ErrorHandler.getErrorMessage(t));

                callback.onError(errorData);
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
            public void onFailure(Call<GetAmountPullRequestsOutput.ResponseData> call, Throwable t) {
                GetAmountPullRequestsOutput.ErrorData errorData = new GetAmountPullRequestsOutput.ErrorData();

                errorData.setMessage(ErrorHandler.getErrorMessage(t));

                callback.onError(errorData);
            }
        });
    }

    private String createQuery(String repositoryUsername, String repositoryName, String state){
        return "+type:pr+repo:"+ repositoryUsername + "/" + repositoryName + "+state:" + state;
    }
}
