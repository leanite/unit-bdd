package org.bitbucket.lcleite.desafioandroid.presentation.presenter.repository;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.presentation.view.RepositoryListView;
import org.bitbucket.lcleite.desafioandroid.ui.PullRequestListActivity;
import org.bitbucket.lcleite.desafioandroid.ui.PullRequestListActivity_;
import org.bitbucket.lcleite.desafioandroid.ui.UserDetailsActivity;
import org.bitbucket.lcleite.desafioandroid.ui.UserDetailsActivity_;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public class RepositoryListPresenterImpl implements RepositoryListPresenter {

    private RepositoryListView repositoryView;
    private Context context;

    @Override
    public void setView(RepositoryListView view) {
        repositoryView = view;
        context = (Context) view;
    }

    @Override
    public void goToPullRequestActivity(Repository repository) {
        Intent intent = new Intent(context, PullRequestListActivity_.class);

        Bundle args = getPullRequestActivityArgs(repository);
        intent.putExtra(PullRequestListActivity.ARGS, args);

        context.startActivity(intent);
    }

    public Bundle getPullRequestActivityArgs(Repository repository) {
        Bundle bundle = new Bundle();

        bundle.putString(PullRequestListActivity.REPOSITORY_USERNAME, repository.getOwner().getUsername());
        bundle.putString(PullRequestListActivity.REPOSITORY_NAME, repository.getName());

        return bundle;
    }

    @Override
    public void goToUserDetailsActivity(User user) {
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
    public void onGetRepositoriesSuccess(List<Repository> repositories) {
        repositoryView.updateRepositories(repositories);
        repositoryView.updateUiAfterQuery();
    }

    @Override
    public void onGetRepositoriesError(ErrorData errorData) {

    }
}
