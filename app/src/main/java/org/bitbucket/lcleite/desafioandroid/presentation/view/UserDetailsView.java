package org.bitbucket.lcleite.desafioandroid.presentation.view;

import android.support.design.widget.AppBarLayout;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.ui.adapter.RepositoryListAdapter;
import org.bitbucket.lcleite.desafioandroid.ui.scroll.EndlessScrollListener;

import java.util.List;

/**
 * Created by leandro on 26/12/2017.
 */

public interface UserDetailsView extends
        AppBarLayout.OnOffsetChangedListener, EndlessScrollListener.OnEndlessLoadListener {
    void updateUiWithUserDetails(User user);
    void updateUiWithUserRepositories(List<Repository> repositories);
    void showErrorMessage(String message);
    void updateUiAfterError();
}
