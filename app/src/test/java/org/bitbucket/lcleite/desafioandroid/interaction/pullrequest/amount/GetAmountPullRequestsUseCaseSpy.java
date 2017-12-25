package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.amount;

import org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest.PullRequestDataSource;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsInput;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsUseCase;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsUseCase;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public class GetAmountPullRequestsUseCaseSpy implements GetAmountPullRequestsUseCase {

    private PullRequestDataSource pullRequestDataSource;
    private GetAmountPullRequestsOutput pullRequestMainPresenter;

    public GetAmountPullRequestsUseCaseSpy(PullRequestDataSource pullRequestDataSource, GetAmountPullRequestsOutput pullRequestMainPresenter) {
        this.pullRequestDataSource = pullRequestDataSource;
        this.pullRequestMainPresenter = pullRequestMainPresenter;
    }

    @Override
    public void getAmountPullRequests(RequestData requestData) {
        Repository repository = requestData.getRepository();
        PullRequest.State state = requestData.getState();

        pullRequestDataSource.getAmountPullRequests(repository, state.value(), this);
    }

    @Override
    public void onSuccess(GetAmountPullRequestsOutput.ResponseData responseData) {
        int amountPullRequests = responseData.getAmountPullRequests();
        PullRequest.State state = responseData.getState();

        pullRequestMainPresenter.onGetGetAmountPullRequestsSuccess(amountPullRequests, state);
    }

    @Override
    public void onError(GetAmountPullRequestsOutput.ErrorData errorData) {

    }
}
