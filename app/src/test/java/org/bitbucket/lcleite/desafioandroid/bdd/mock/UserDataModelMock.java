package org.bitbucket.lcleite.desafioandroid.bdd.mock;

import org.bitbucket.lcleite.desafioandroid.data.model.RepositoryDataModel;
import org.bitbucket.lcleite.desafioandroid.data.model.UserDataModel;

import java.util.Arrays;
import java.util.List;

public class UserDataModelMock {

    public static UserDataModel getSingle(){
        UserDataModel userDataModel = new UserDataModel();

        userDataModel.setId(1);
        userDataModel.setUsername("user");
        userDataModel.setName("Repo User");
        userDataModel.setAvatarUrl("http://user.com/avatar");

        return userDataModel;
    }
}
