package org.bitbucket.lcleite.desafioandroid.bdd.mock;

import org.bitbucket.lcleite.desafioandroid.data.model.RepositoryDataModel;
import org.bitbucket.lcleite.desafioandroid.data.model.UserDataModel;

import java.util.Arrays;
import java.util.List;

public class RepositoryDataModelMock {

    public static List<RepositoryDataModel> getList() {

        return Arrays.asList(
                getRepositoryDataModelMock(),
                getRepositoryDataModelMock(),
                getRepositoryDataModelMock());
    }

    private static RepositoryDataModel getRepositoryDataModelMock(){
        RepositoryDataModel repositoryDataModel = new RepositoryDataModel();
        UserDataModel owner = UserDataModelMock.getSingle();

        repositoryDataModel.setOwner(owner);
        repositoryDataModel.setName("repoName");
        repositoryDataModel.setFullName("user/repoName");
        repositoryDataModel.setUrl("http://repo.com");
        repositoryDataModel.setDescription("Description");
        repositoryDataModel.setForks(20);
        repositoryDataModel.setStars(100);
        repositoryDataModel.setIssues(10);

        return repositoryDataModel;
    }

    private static UserDataModel getOwnerDataModelMock(){
        UserDataModel userDataModel = new UserDataModel();

        userDataModel.setId(1);
        userDataModel.setUsername("user");
        userDataModel.setName("Repo User");
        userDataModel.setAvatarUrl("http://user.com/avatar");

        return userDataModel;
    }
}
