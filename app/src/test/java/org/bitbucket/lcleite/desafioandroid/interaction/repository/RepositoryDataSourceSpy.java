package org.bitbucket.lcleite.desafioandroid.interaction.repository;

import org.bitbucket.lcleite.desafioandroid.data.datasource.repository.RepositoryDataSource;
import org.bitbucket.lcleite.desafioandroid.data.service.RepositoryRetrofitService;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leandro on 22/12/2017.
 */

public class RepositoryDataSourceSpy implements RepositoryDataSource {

    private Retrofit retrofit;
    private RepositoryRetrofitService service;

    public RepositoryDataSourceSpy() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new GetRepositoriesMockInterceptor())
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        service = retrofit.create(RepositoryRetrofitService.class);
    }

    @Override
    public void getRepositoriesAtPageNumber(int pageNumber, Callback<GetRepositoriesOutput.ResponseData> callback) {
        Call<GetRepositoriesOutput.ResponseData> call = service.getRepositoriesAtPageNumber(pageNumber);

        try {
            callback.onResponse(call, call.execute());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
