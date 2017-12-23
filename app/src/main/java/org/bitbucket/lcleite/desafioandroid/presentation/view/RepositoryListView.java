package org.bitbucket.lcleite.desafioandroid.presentation.view;

import android.support.v4.widget.SwipeRefreshLayout;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.ui.adapter.RepositoryListAdapter;

import java.util.List;

/**
 * Created by leandro on 23/12/2017.
 */

public interface RepositoryListView extends
        SwipeRefreshLayout.OnRefreshListener, RepositoryListAdapter.OnItemClickListener {

    void updateRepositories(List<Repository> repositories);
    void updateUiAfterQuery();
}
