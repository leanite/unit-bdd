package org.bitbucket.lcleite.desafioandroid.interaction.repository;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.userrepository.GetUserRepositoriesOutput;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.repository.RepositoryListPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.view.RepositoryListView;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public class RepositoryListPresenterSpy implements GetRepositoriesOutput, GetUserRepositoriesOutput {

    private List<Repository> repositories;

    public List<Repository> getRepositories() {
        return repositories;
    }

    @Override
    public void onGetRepositoriesSuccess(List<Repository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public void onGetRepositoriesError(GetRepositoriesOutput.ErrorData errorData) {

    }

    @Override
    public void onGetUserRepositoriesSuccess(List<Repository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public void onGetUserRepositoriesError(GetUserRepositoriesOutput.ErrorData errorData) {

    }
}
