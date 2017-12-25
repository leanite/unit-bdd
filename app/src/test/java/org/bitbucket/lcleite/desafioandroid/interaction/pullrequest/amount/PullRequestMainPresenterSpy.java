package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.amount;


import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestListPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestMainPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.view.PullRequestListView;
import org.bitbucket.lcleite.desafioandroid.presentation.view.PullRequestMainView;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public class PullRequestMainPresenterSpy implements PullRequestMainPresenter {

    private int amountPullRequests;
    private PullRequest.State state;

    public int getAmountPullRequests() {
        return amountPullRequests;
    }

    public PullRequest.State getState() {
        return state;
    }

    @Override
    public void onGetGetAmountPullRequestsSuccess(int amountPullRequests, PullRequest.State state) {
        this.amountPullRequests = amountPullRequests;
        this.state = state;
    }

    @Override
    public void onGetGetAmountPullRequestsError(ErrorData errorData) {

    }

    @Override
    public void setView(PullRequestMainView view) {}
}
