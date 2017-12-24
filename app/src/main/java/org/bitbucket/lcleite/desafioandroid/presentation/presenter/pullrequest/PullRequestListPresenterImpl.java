package org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest;

import android.content.Context;
import android.support.v4.app.Fragment;

import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.presentation.view.PullRequestListView;

import java.util.List;

/**
 * Created by leandro on 23/12/2017.
 */

public class PullRequestListPresenterImpl implements PullRequestListPresenter {
    private PullRequestListView pullRequestView;
    private Context context;

    @Override
    public void setView(PullRequestListView view) {
        pullRequestView = view;
        context = ((Fragment) view).getContext();
    }

    @Override
    public void onGetPullRequestsSuccess(List<PullRequest> pullRequests) {
        pullRequestView.updatePullRequests(pullRequests);
        pullRequestView.updateUiAfterQuery();
    }

    @Override
    public void onGetPullRequestsError(ErrorData errorData) {

    }
}
