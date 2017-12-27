package org.bitbucket.lcleite.desafioandroid.interaction.userrepository;

import org.bitbucket.lcleite.desafioandroid.data.datasource.repository.RepositoryDataSource;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;

import java.util.List;

/**
 * Created by leandro on 26/12/2017.
 */

public class GetUserRepositoriesUseCaseImpl implements GetUserRepositoriesUseCase {

    private RepositoryDataSource repositoryDataSource;
    private GetUserRepositoriesOutput userDetailsPresenter;

    public GetUserRepositoriesUseCaseImpl(RepositoryDataSource repositoryDataSource, GetUserRepositoriesOutput userDetailsPresenter) {
        this.repositoryDataSource = repositoryDataSource;
        this.userDetailsPresenter = userDetailsPresenter;
    }

    @Override
    public void getUserRepositories(RequestData requestData) {
        String username = requestData.getUsername();
        int pageNumber = requestData.getPageNumber();

        repositoryDataSource.getUserRepositoriesAtPageNumber(username, pageNumber, this);
    }

    @Override
    public void onSuccess(List<Repository> responseData) {
        userDetailsPresenter.onGetUserRepositoriesSuccess(responseData);
    }

    @Override
    public void onError(GetUserRepositoriesOutput.ErrorData errorData) {

    }
}
