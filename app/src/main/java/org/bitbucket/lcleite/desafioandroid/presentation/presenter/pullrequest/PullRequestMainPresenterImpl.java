package org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest;

import android.content.Context;

import org.bitbucket.lcleite.desafioandroid.presentation.view.PullRequestMainView;

/**
 * Created by leandro on 24/12/2017.
 */

public class PullRequestMainPresenterImpl implements PullRequestMainPresenter {
    private PullRequestMainView pullRequestView;
    private Context context;

    @Override
    public void setView(PullRequestMainView view) {
        pullRequestView = view;
        context = (Context) view;
    }

    @Override
    public void onGetGetAmountPullRequestssSuccess(int amountPullRequests) {
        //pullRequestView.updateAmountPullRequests(amountPullRequests);
    }

    @Override
    public void onGetGetAmountPullRequestsError(ErrorData errorData) {

    }
}
