package org.bitbucket.lcleite.desafioandroid.bdd;

import com.google.gson.Gson;

import org.bitbucket.lcleite.desafioandroid.bdd.mock.RepositoryDataModelMock;
import org.bitbucket.lcleite.desafioandroid.data.datasource.repository.RepositoryDataSource;
import org.bitbucket.lcleite.desafioandroid.data.mapper.RepositoryDataModelMapper;
import org.bitbucket.lcleite.desafioandroid.data.model.RepositoryDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.UseCaseCallback;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.userrepository.GetUserRepositoriesOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;


public class RepositoryDataSourceNoRetrofit /*implements RepositoryDataSource*/ {

    public GetRepositoriesOutput.ResponseData getRepositoriesAtPageNumber(int pageNumber) {

        return MockResponse.fromJson("list_repositories.json",
                GetRepositoriesOutput.ResponseData.class);
    }

//    @Override
//    public void getUserRepositoriesAtPageNumber(
//            String username, int pageNumber,
//            UseCaseCallback<List<Repository>, GetUserRepositoriesOutput.ErrorData> callback) {}
}
