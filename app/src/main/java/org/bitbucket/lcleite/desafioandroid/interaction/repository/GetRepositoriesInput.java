package org.bitbucket.lcleite.desafioandroid.interaction.repository;


import org.bitbucket.lcleite.desafioandroid.presentation.presenter.repository.RepositoryListPresenter;

/**
 * Created by leandro on 22/12/2017.
 */

public interface GetRepositoriesInput {

    void getRepositories(RequestData requestData);

    class RequestData {
        private int pageNumber;

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }
    }
}
