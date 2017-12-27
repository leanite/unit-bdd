package org.bitbucket.lcleite.desafioandroid.interaction.repository;

import org.bitbucket.lcleite.desafioandroid.data.datasource.repository.RepositoryDataSource;
import org.bitbucket.lcleite.desafioandroid.data.mapper.RepositoryDataModelMapper;
import org.bitbucket.lcleite.desafioandroid.data.model.RepositoryDataModel;
import org.bitbucket.lcleite.desafioandroid.data.service.RepositoryRetrofitService;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.UseCaseCallback;
import org.bitbucket.lcleite.desafioandroid.interaction.userrepository.GetUserRepositoriesOutput;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leandro on 26/12/2017.
 */

public class UserRepositoryDataSourceSpy implements RepositoryDataSource {

    private Retrofit retrofit;
    private RepositoryRetrofitService service;
    private RepositoryDataModelMapper repositoryDataMapper;

    public UserRepositoryDataSourceSpy() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new GetUserRepositoriesMockInterceptor())
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        service = retrofit.create(RepositoryRetrofitService.class);
        repositoryDataMapper = new RepositoryDataModelMapper();
    }

    @Override
    public void getRepositoriesAtPageNumber(
            int pageNumber,
            UseCaseCallback<List<Repository>, GetRepositoriesOutput.ErrorData> callback) {}

    @Override
    public void getUserRepositoriesAtPageNumber(
            String username, int pageNumber,
            UseCaseCallback<List<Repository>, GetUserRepositoriesOutput.ErrorData> callback) {

        Call<List<RepositoryDataModel>> call = service.getUserRepositoriesAtPageNumber(username, pageNumber);

        try {
            Response<List<RepositoryDataModel>> response = call.execute();
            List<RepositoryDataModel> repositoriesData = response.body();
            List<Repository> repositories = repositoryDataMapper.toEntityList(repositoriesData);

            callback.onSuccess(repositories);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
