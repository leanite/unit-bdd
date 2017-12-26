package org.bitbucket.lcleite.desafioandroid.data.datasource.repository;

import org.bitbucket.lcleite.desafioandroid.data.mapper.RepositoryDataModelMapper;
import org.bitbucket.lcleite.desafioandroid.data.model.RepositoryDataModel;
import org.bitbucket.lcleite.desafioandroid.data.service.RepositoryRetrofitService;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.UseCaseCallback;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesOutput;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by leandro on 22/12/2017.
 */

public class RepositoryNetwork implements RepositoryDataSource{

    private RepositoryRetrofitService service;
    private RepositoryDataModelMapper repositoryDataMapper;

    public RepositoryNetwork(Retrofit retrofit) {
        service = retrofit.create(RepositoryRetrofitService.class);
        repositoryDataMapper = new RepositoryDataModelMapper();
    }

    @Override
    public void getRepositoriesAtPageNumber(
            int pageNumber,
            final UseCaseCallback<List<Repository>, GetRepositoriesOutput.ErrorData> callback) {

        Call<GetRepositoriesOutput.ResponseData> call = service.getRepositoriesAtPageNumber(pageNumber);

        call.enqueue(new Callback<GetRepositoriesOutput.ResponseData>() {
            @Override
            public void onResponse(Call<GetRepositoriesOutput.ResponseData> call, Response<GetRepositoriesOutput.ResponseData> response) {
                List<RepositoryDataModel> repositoriesData = response.body().getRepositories();
                List<Repository> repositories = repositoryDataMapper.toEntityList(repositoriesData);

                callback.onSuccess(repositories);
            }

            @Override
            public void onFailure(Call<GetRepositoriesOutput.ResponseData> call, Throwable t) {

            }
        });
    }
}
