package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;


import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestListPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.view.PullRequestListView;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public class PullRequestListPresenterSpy implements PullRequestListPresenter {

    private List<PullRequest> pullRequests;

    public List<PullRequest> getPullRequests() {
        return pullRequests;
    }

    @Override
    public void onGetPullRequestsSuccess(List<PullRequest> pullRequests) {
        this.pullRequests = pullRequests;
    }

    @Override
    public void onGetPullRequestsError(ErrorData errorData) {

    }

    @Override
    public void setView(PullRequestListView view) {}
}
