package org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.presentation.view.PullRequestListView;
import org.bitbucket.lcleite.desafioandroid.ui.UserDetailsActivity;
import org.bitbucket.lcleite.desafioandroid.ui.UserDetailsActivity_;

import java.util.List;

/**
 * Created by leandro on 23/12/2017.
 */

public class PullRequestListPresenterImpl implements PullRequestListPresenter {
    private PullRequestListView pullRequestView;

    @Override
    public void setView(PullRequestListView view) {
        pullRequestView = view;
    }

    @Override
    public void goToPullRequestUrl(String url, Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        context.startActivity(intent);
    }

    @Override
    public void goToUserDetailsActivity(User user, Context context) {
        Intent intent = new Intent(context, UserDetailsActivity_.class);

        Bundle args = getUserDetailsActivityArgs(user);
        intent.putExtra(UserDetailsActivity.ARGS, args);

        context.startActivity(intent);
    }

    private Bundle getUserDetailsActivityArgs(User user) {
        Bundle bundle = new Bundle();

        bundle.putString(UserDetailsActivity.USER_USERNAME, user.getUsername());

        return bundle;
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
