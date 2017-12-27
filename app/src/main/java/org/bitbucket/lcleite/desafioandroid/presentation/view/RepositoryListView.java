package org.bitbucket.lcleite.desafioandroid.presentation.view;

import android.support.v4.widget.SwipeRefreshLayout;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.ui.adapter.RepositoryListAdapter;
import org.bitbucket.lcleite.desafioandroid.ui.scroll.EndlessScrollListener;

import java.util.List;

/**
 * Created by leandro on 23/12/2017.
 */

public interface RepositoryListView extends
        SwipeRefreshLayout.OnRefreshListener, RepositoryListAdapter.OnItemClickListener,
        EndlessScrollListener.OnEndlessLoadListener {

    void updateRepositories(List<Repository> repositories);
    void updateUiAfterQuery();
    void showErrorMessage(String message);
    void updateUiAfterError();
}
