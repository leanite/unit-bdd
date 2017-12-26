package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;


import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.interaction.UseCaseCallback;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public interface GetPullRequestsUseCase extends
        GetPullRequestsInput,
        UseCaseCallback<List<PullRequest>, GetPullRequestsOutput.ErrorData> {
}
