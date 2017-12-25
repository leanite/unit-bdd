package org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest;


import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.UseCaseCallback;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsOutput;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public interface PullRequestDataSource {
    void getPullRequests(
            String repositoryUsername, String repositoryName,
            String state, int pageNumber,
            UseCaseCallback<List<PullRequest>, GetPullRequestsOutput.ErrorData> callback);

    void getAmountPullRequests(
            String repositoryUsername, String repositoryName,
            String state,
            UseCaseCallback<GetAmountPullRequestsOutput.ResponseData, GetAmountPullRequestsOutput.ErrorData> callback) ;
}
