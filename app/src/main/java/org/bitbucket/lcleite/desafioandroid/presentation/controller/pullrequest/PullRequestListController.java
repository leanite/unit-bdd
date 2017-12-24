package org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsUseCase;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsInput;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsUseCase;

/**
 * Created by leandro on 22/12/2017.
 */

public class PullRequestListController {

    private GetPullRequestsUseCase getPullRequestsUseCase;

    public PullRequestListController(
            GetPullRequestsUseCase getPullRequestsUseCase) {
        this.getPullRequestsUseCase = getPullRequestsUseCase;
    }

    public void getPullRequests(Repository repository, String state, int pageNumber){
        GetPullRequestsInput.RequestData requestData = new GetPullRequestsInput.RequestData();

        requestData.setRepository(repository);
        requestData.setState(state);
        requestData.setPageNumber(pageNumber);

        getPullRequestsUseCase.getPullRequests(requestData);
    }
}
