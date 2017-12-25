package org.bitbucket.lcleite.desafioandroid.interaction.repository;

import org.bitbucket.lcleite.desafioandroid.data.datasource.repository.RepositoryDataSource;
import org.bitbucket.lcleite.desafioandroid.data.mapper.RepositoryDataModelMapper;
import org.bitbucket.lcleite.desafioandroid.data.model.RepositoryDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.repository.RepositoryListPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by leandro on 22/12/2017.
 */

public class GetRepositoriesUseCaseSpy implements GetRepositoriesUseCase {

    private RepositoryDataSource repositoryDataSource;
    private GetRepositoriesOutput repositoryListPresenter;

    public GetRepositoriesUseCaseSpy(RepositoryDataSource repositoryDataSource, GetRepositoriesOutput repositoryListPresenter) {
        this.repositoryDataSource = repositoryDataSource;
        this.repositoryListPresenter = repositoryListPresenter;
    }

    @Override
    public void getRepositories(RequestData requestData) {
        int pageNumber = requestData.getPageNumber();

        repositoryDataSource.getRepositoriesAtPageNumber(pageNumber, this);
    }

    @Override
    public void onSuccess(List<Repository> responseData) {
        repositoryListPresenter.onGetRepositoriesSuccess(responseData);
    }

    @Override
    public void onError(GetRepositoriesOutput.ErrorData errorData) {

    }
}
