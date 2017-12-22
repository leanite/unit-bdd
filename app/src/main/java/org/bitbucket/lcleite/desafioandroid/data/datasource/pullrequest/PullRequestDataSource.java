package org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest;


import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsOutput;

import retrofit2.Callback;

/**
 * Created by leandro on 22/12/2017.
 */

public interface PullRequestDataSource {
    void getPullRequests(
            Repository repository,
            String state,
            int pageNumber,
            Callback<GetPullRequestsOutput.ResponseData> callback);
}
