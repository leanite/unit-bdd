package org.bitbucket.lcleite.desafioandroid.presentation.view;

import android.support.v4.widget.SwipeRefreshLayout;

import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.ui.adapter.PullRequestListAdapter;
import org.bitbucket.lcleite.desafioandroid.ui.scroll.EndlessScrollListener;

import java.util.List;

/**
 * Created by leandro on 23/12/2017.
 */

public interface PullRequestListView extends
        SwipeRefreshLayout.OnRefreshListener, PullRequestListAdapter.OnItemClickListener,
        EndlessScrollListener.OnEndlessLoadListener {

    void updatePullRequests(List<PullRequest> pullRequests);
    void updateUiAfterQuery();
}
