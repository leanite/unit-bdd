package org.bitbucket.lcleite.desafioandroid.interaction.repository;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.repository.RepositoryListPresenter;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public class RepositoryListPresenterSpy implements RepositoryListPresenter {

    private List<Repository> repositories;

    public List<Repository> getRepositories() {
        return repositories;
    }

    @Override
    public void onGetRepositoriesSuccess(List<Repository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public void onGetRepositoriesError(ErrorData errorData) {

    }
}
