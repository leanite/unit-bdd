package org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest;

import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.presentation.view.PullRequestListView;

/**
 * Created by leandro on 22/12/2017.
 */

public interface PullRequestListPresenter extends GetPullRequestsOutput {
    void setView(PullRequestListView view);
}
