package org.bitbucket.lcleite.desafioandroid.presentation.presenter.repository;

import android.content.Context;
import android.util.Log;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.presentation.view.RepositoryListView;

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
    public void onGetRepositoriesSuccess(List<Repository> repositories) {
        Log.d("OK", repositories.toArray().toString());
        repositoryView.updateRepositories(repositories);
        repositoryView.updateUiAfterQuery();
    }

    @Override
    public void onGetRepositoriesError(ErrorData errorData) {

    }
}
