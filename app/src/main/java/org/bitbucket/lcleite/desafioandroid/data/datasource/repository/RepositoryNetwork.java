package org.bitbucket.lcleite.desafioandroid.data.datasource.repository;

import org.bitbucket.lcleite.desafioandroid.data.service.RepositoryRetrofitService;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesOutput;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leandro on 22/12/2017.
 */

public class RepositoryNetwork implements RepositoryDataSource{

    //FIXME: Dependency Injection

    private Retrofit retrofit;
    private RepositoryRetrofitService service;

    public RepositoryNetwork() {
        //TODO: Add Cache
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RepositoryRetrofitService.class);
    }

    @Override
    public void getRepositoriesAtPageNumber(int pageNumber, Callback<GetRepositoriesOutput.ResponseData> callback) {
        Call<GetRepositoriesOutput.ResponseData> call = service.getRepositoriesAtPageNumber(pageNumber);

        call.enqueue(callback);
    }
}
