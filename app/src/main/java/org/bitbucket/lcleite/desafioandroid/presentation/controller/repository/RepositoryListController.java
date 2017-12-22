package org.bitbucket.lcleite.desafioandroid.presentation.controller.repository;

import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesInput;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesUseCase;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.repository.RepositoryListPresenter;

/**
 * Created by leandro on 22/12/2017.
 */

public class RepositoryListController {

    private RepositoryListPresenter presenter;
    private GetRepositoriesUseCase getRepositoriesUseCase;

    public RepositoryListController(RepositoryListPresenter presenter, GetRepositoriesUseCase getRepositoriesUseCase) {
        this.presenter = presenter;
        this.getRepositoriesUseCase = getRepositoriesUseCase;
    }

    public void getRepositories(int pageNumber){
        GetRepositoriesInput.RequestData requestData = new GetRepositoriesInput.RequestData();
        requestData.setPageNumber(pageNumber);

        getRepositoriesUseCase.getRepositories(requestData, presenter);
    }
}
