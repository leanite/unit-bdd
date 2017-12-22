package org.bitbucket.lcleite.desafioandroid.data.datasource.repository;

import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesOutput;

import retrofit2.Callback;

/**
 * Created by leandro on 22/12/2017.
 */

public interface RepositoryDataSource {
    void getRepositoriesAtPageNumber(int pageNumber, Callback<GetRepositoriesOutput.ResponseData> callback);
}
