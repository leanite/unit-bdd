package org.bitbucket.lcleite.desafioandroid.presentation.presenter.repository;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesOutput;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public class RepositoryListPresenterImpl implements RepositoryListPresenter {

    @Override
    public void onGetRepositoriesSuccess(List<Repository> repositories) {

    }

    @Override
    public void onGetRepositoriesError(ErrorData errorData) {

    }
}
