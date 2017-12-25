package org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest;

import android.util.Log;

import org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest.PullRequestDataSource;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by leandro on 24/12/2017.
 */

public class GetAmountPullRequestsUseCaseImpl implements GetAmountPullRequestsUseCase {

    private PullRequestDataSource pullRequestDataSource;
    private GetAmountPullRequestsOutput amountPullRequestListPresenter;

    public GetAmountPullRequestsUseCaseImpl(PullRequestDataSource pullRequestDataSource, GetAmountPullRequestsOutput amountPullRequestListPresenter) {
        this.pullRequestDataSource = pullRequestDataSource;
        this.amountPullRequestListPresenter = amountPullRequestListPresenter;
    }

    @Override
    public void getAmountPullRequests(RequestData requestData) {
        String repositoryUsername = requestData.getRepositoryUsername();
        String repositoryName = requestData.getRepositoryName();
        PullRequest.State state = requestData.getState();

        pullRequestDataSource.getAmountPullRequests(repositoryUsername, repositoryName, state.value(), this);
    }

    @Override
    public void onSuccess(GetAmountPullRequestsOutput.ResponseData responseData) {
        int amountPullRequests = responseData.getAmountPullRequests();
        PullRequest.State state = responseData.getState();

        amountPullRequestListPresenter.onGetGetAmountPullRequestsSuccess(amountPullRequests, state);
    }

    @Override
    public void onError(GetAmountPullRequestsOutput.ErrorData errorData) {

    }
}
