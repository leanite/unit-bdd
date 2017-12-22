package org.bitbucket.lcleite.desafioandroid.interaction.repository;


import org.bitbucket.lcleite.desafioandroid.presentation.presenter.repository.RepositoryListPresenter;

/**
 * Created by leandro on 22/12/2017.
 */

public interface GetRepositoriesInput {

    void getRepositories(RequestData requestData, RepositoryListPresenter presenter);

    class RequestData {
        public int pageNumber;
    }
}
