package org.bitbucket.lcleite.desafioandroid.presentation.controller.repository;

import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesInput;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesUseCase;

/**
 * Created by leandro on 22/12/2017.
 */

public class RepositoryListController {

    private GetRepositoriesUseCase getRepositoriesUseCase;

    public RepositoryListController(GetRepositoriesUseCase getRepositoriesUseCase) {
        this.getRepositoriesUseCase = getRepositoriesUseCase;
    }

    public void getRepositories(int pageNumber){
        GetRepositoriesInput.RequestData requestData = new GetRepositoriesInput.RequestData();
        requestData.setPageNumber(pageNumber);

        getRepositoriesUseCase.getRepositories(requestData);
    }
}
