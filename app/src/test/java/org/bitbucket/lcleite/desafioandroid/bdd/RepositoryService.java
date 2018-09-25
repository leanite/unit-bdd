package org.bitbucket.lcleite.desafioandroid.bdd;

import org.bitbucket.lcleite.desafioandroid.data.datasource.repository.RepositoryDataSource;
import org.bitbucket.lcleite.desafioandroid.data.mapper.RepositoryDataModelMapper;
import org.bitbucket.lcleite.desafioandroid.data.model.RepositoryDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.UseCaseCallback;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.userrepository.GetUserRepositoriesOutput;

import java.util.List;

public class RepositoryService implements RepositoryDataSource {//fixme: implements RepositoryService

    private RepositoryDataModelMapper repositoryDataMapper;
    private RepositoryDataSourceNoRetrofit repositoryDataSource;

    public RepositoryService(RepositoryDataSourceNoRetrofit repositoryDataSource) {
        repositoryDataMapper = new RepositoryDataModelMapper();
        this.repositoryDataSource = repositoryDataSource;
    }

    @Override
    public void getRepositoriesAtPageNumber(int pageNumber,
            UseCaseCallback<List<Repository>, GetRepositoriesOutput.ErrorData> callback) {

        GetRepositoriesOutput.ResponseData response =
                repositoryDataSource.getRepositoriesAtPageNumber(pageNumber);

        List<RepositoryDataModel> repositoriesData = response.getRepositories();
        List<Repository> repositories = repositoryDataMapper.toEntityList(repositoriesData);

        callback.onSuccess(repositories);
    }

    @Override
    public void getUserRepositoriesAtPageNumber(
            String username, int pageNumber,
            UseCaseCallback<List<Repository>, GetUserRepositoriesOutput.ErrorData> callback) {}
}
