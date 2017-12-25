package org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest;


import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.UseCaseCallback;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsOutput;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public interface PullRequestDataSource {
    void getPullRequests(
            Repository repository,
            String state,
            int pageNumber,
            UseCaseCallback<List<PullRequest>, GetPullRequestsOutput.ErrorData> callback);

    void getAmountPullRequests(
            Repository repository,
            String state,
            UseCaseCallback<GetAmountPullRequestsOutput.ResponseData, GetAmountPullRequestsOutput.ErrorData> callback) ;
}
