package org.bitbucket.lcleite.desafioandroid.interaction.repository;

import com.google.gson.annotations.SerializedName;

import org.bitbucket.lcleite.desafioandroid.data.model.RepositoryDataModel;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public interface GetRepositoriesOutput {
    void onGetRepositoriesSuccess(ResponseData responseData);
    void onGetRepositoriesError(ErrorData errorData);

    class ResponseData{

        @SerializedName("items")
        private List<RepositoryDataModel> repositories;

        public List<RepositoryDataModel> getRepositories() {
            return repositories;
        }

        public void setRepositories(List<RepositoryDataModel> repositories) {
            this.repositories = repositories;
        }
    }

    class ErrorData{

    }
}
