package org.bitbucket.lcleite.desafioandroid.interaction.repository.impl;

import org.bitbucket.lcleite.desafioandroid.data.datasource.repository.RepositoryDataSource;
import org.bitbucket.lcleite.desafioandroid.data.mapper.RepositoryDataModelMapper;
import org.bitbucket.lcleite.desafioandroid.data.model.RepositoryDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesInput;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesUseCase;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.repository.RepositoryListPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by leandro on 22/12/2017.
 */

public class GetRepositoriesUseCaseImpl implements GetRepositoriesUseCase, Callback<GetRepositoriesOutput.ResponseData> {

    private RepositoryDataSource repositoryDataSource;
    private RepositoryListPresenter repositoryListPresenter; //FIXME: RepositoryListPresenter -> GetRepositoriesInput
    private RepositoryDataModelMapper repositoryDataMapper;

    public GetRepositoriesUseCaseImpl(RepositoryDataSource repositoryDataSource, RepositoryListPresenter repositoryListPresenter) {
        this.repositoryDataSource = repositoryDataSource;
        this.repositoryListPresenter = repositoryListPresenter;
        this.repositoryDataMapper = new RepositoryDataModelMapper();
    }

    @Override
    public void getRepositories(RequestData requestData, /*FIXME: remove*/RepositoryListPresenter presenter) {
        int pageNumber = requestData.getPageNumber();

        repositoryDataSource.getRepositoriesAtPageNumber(pageNumber, this);
    }

    @Override
    public void onResponse(Call<GetRepositoriesOutput.ResponseData> call, Response<GetRepositoriesOutput.ResponseData> response) {
        List<RepositoryDataModel> repositoriesData = response.body().getRepositories();
        List<Repository> repositories = repositoryDataMapper.toEntityList(repositoriesData);

        repositoryListPresenter.onGetRepositoriesSuccess(repositories);
    }

    @Override
    public void onFailure(Call<GetRepositoriesOutput.ResponseData> call, Throwable t) {

    }
}
