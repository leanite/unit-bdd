package org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest;

import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsInput;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsUseCase;

/**
 * Created by leandro on 24/12/2017.
 */

public class PullRequestMainController {
    private GetAmountPullRequestsUseCase getAmountPullRequestsUseCase;

    public PullRequestMainController(GetAmountPullRequestsUseCase getAmountPullRequestsUseCase) {
        this.getAmountPullRequestsUseCase = getAmountPullRequestsUseCase;
    }

    public void getAmountPullRequestsUseCase(Repository repository, PullRequest.State state){
        GetAmountPullRequestsInput.RequestData requestData = new GetAmountPullRequestsInput.RequestData();

        requestData.setRepository(repository);
        requestData.setState(state);

        getAmountPullRequestsUseCase.getAmountPullRequests(requestData);
    }
}
