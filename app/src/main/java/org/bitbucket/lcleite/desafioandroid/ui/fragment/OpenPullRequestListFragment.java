package org.bitbucket.lcleite.desafioandroid.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest.PullRequestListController;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestListPresenter;

/**
 * Created by leandro on 24/12/2017.
 */

public class OpenPullRequestListFragment extends PullRequestListFragment {

    public static OpenPullRequestListFragment newInstance(PullRequestListPresenter presenter, PullRequestListController controller) {
        OpenPullRequestListFragment fragment = new OpenPullRequestListFragment(presenter, controller);

        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public OpenPullRequestListFragment() {}

    @SuppressLint("ValidFragment")
    public OpenPullRequestListFragment(PullRequestListPresenter presenter, PullRequestListController controller) {
        setPresenter(presenter);
        setController(controller);
    }

    @Override
    String getPullRequestState() {
        return PullRequest.State.open.value();
    }

    @Override
    void setPresenter(PullRequestListPresenter presenter) {
        this.pullRequestListPresenter = presenter;
        this.pullRequestListPresenter.setView(this);
    }

    @Override
    void setController(PullRequestListController controller) {
        this.pullRequestListController = controller;
    }
}
