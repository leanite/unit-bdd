package org.bitbucket.lcleite.desafioandroid.interaction.userrepository;

import org.bitbucket.lcleite.desafioandroid.data.model.RepositoryDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;

import java.util.List;

/**
 * Created by leandro on 26/12/2017.
 */

public interface GetUserRepositoriesOutput {
    void onGetUserRepositoriesSuccess(List<Repository> repositories);
    void onGetUserRepositoriesError(ErrorData errorData);

    class ErrorData{

    }
}
