package org.bitbucket.lcleite.desafioandroid.data.datasource.repository;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.UseCaseCallback;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.userrepository.GetUserRepositoriesOutput;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public interface RepositoryDataSource {
    void getRepositoriesAtPageNumber(int pageNumber,
                                     UseCaseCallback<List<Repository>, GetRepositoriesOutput.ErrorData> callback);

    void getUserRepositoriesAtPageNumber(String username, int pageNumber,
                                     UseCaseCallback<List<Repository>, GetUserRepositoriesOutput.ErrorData> callback);
}
