package org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest;

import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsOutput;
import org.bitbucket.lcleite.desafioandroid.presentation.view.PullRequestMainView;

/**
 * Created by leandro on 24/12/2017.
 */

public interface PullRequestMainPresenter extends GetAmountPullRequestsOutput {
    void setView(PullRequestMainView view);
}
