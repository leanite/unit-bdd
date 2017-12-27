package org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest;

import android.content.Context;

import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.presentation.view.PullRequestListView;

/**
 * Created by leandro on 22/12/2017.
 */

public interface PullRequestListPresenter extends GetPullRequestsOutput {
    void setView(PullRequestListView view);
    void goToPullRequestUrl(String url, Context context);
    void goToUserDetailsActivity(User user, Context context);
}
