package org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest;

import android.content.Context;

import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
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
    public void onGetGetAmountPullRequestsSuccess(int amountPullRequests, PullRequest.State state) {
        switch (state){
            case open:
                pullRequestView.updateAmountOpenPullRequests(amountPullRequests);
                break;
            case closed:
                pullRequestView.updateAmountClosedPullRequests(amountPullRequests);
                break;
        }
    }

    @Override
    public void onGetGetAmountPullRequestsError(ErrorData errorData) {

    }
}
