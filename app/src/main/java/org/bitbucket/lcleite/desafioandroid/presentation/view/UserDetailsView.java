package org.bitbucket.lcleite.desafioandroid.presentation.view;

import android.support.design.widget.AppBarLayout;

import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.ui.adapter.RepositoryListAdapter;
import org.bitbucket.lcleite.desafioandroid.ui.scroll.EndlessScrollListener;

/**
 * Created by leandro on 26/12/2017.
 */

public interface UserDetailsView extends
        RepositoryListAdapter.OnItemClickListener,
        AppBarLayout.OnOffsetChangedListener, EndlessScrollListener.OnEndlessLoadListener {
    void updateUiWithUserDetails(User user);
}
