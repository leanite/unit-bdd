package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;

import org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest.PullRequestDataSource;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public class GetPullRequestsUseCaseImpl implements GetPullRequestsUseCase {
    private PullRequestDataSource pullRequestDataSource;
    private GetPullRequestsOutput pullRequestListPresenter;

    public GetPullRequestsUseCaseImpl(PullRequestDataSource pullRequestDataSource, GetPullRequestsOutput pullRequestListPresenter) {
        this.pullRequestDataSource = pullRequestDataSource;
        this.pullRequestListPresenter = pullRequestListPresenter;
    }

    @Override
    public void getPullRequests(RequestData requestData) {
        String repositoryUsername = requestData.getRepositoryUsername();
        String repositoryName = requestData.getRepositoryName();
        PullRequest.State state = requestData.getState();
        int pageNumber = requestData.getPageNumber();

        pullRequestDataSource.getPullRequests(repositoryUsername, repositoryName, state.value(), pageNumber, this);
    }

    @Override
    public void onSuccess(List<PullRequest> responseData) {
        pullRequestListPresenter.onGetPullRequestsSuccess(responseData);
    }

    @Override
    public void onError(GetPullRequestsOutput.ErrorData errorData) {
        pullRequestListPresenter.onGetPullRequestsError(errorData);
    }
}
