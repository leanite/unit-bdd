package org.bitbucket.lcleite.desafioandroid.data.mapper;

import org.bitbucket.lcleite.desafioandroid.data.model.UserDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by leandro on 22/12/2017.
 */

public class UserDataMapperTest {

    private UserDataModelMapper userDataModelMapper;

    @Before
    public void setup(){
        userDataModelMapper = new UserDataModelMapper();
    }

    @Test
    public void itShould_mapUserDataModelToUserEntity(){
        UserDataModel userDataModel = getUserDataModelMock();
        User user = userDataModelMapper.toEntity(userDataModel);

        assertTrue(user.equals(getExpectedUser()));
    }

    private UserDataModel getUserDataModelMock(){
        UserDataModel userDataModel = new UserDataModel();

        userDataModel.setId(17);
        userDataModel.setUsername("lcleite");
        userDataModel.setName("Leandro Leite");
        userDataModel.setAvatarUrl("http://me.com/avatar");
        userDataModel.setWebsiteUrl("http://me.com");
        userDataModel.setLocation("Brazil");
        userDataModel.setAmountRepositories(20);

        return userDataModel;
    }

    private User getExpectedUser(){
        User user = new User();

        user.setId(17);
        user.setUsername("lcleite");
        user.setName("Leandro Leite");
        user.setAvatarUrl("http://me.com/avatar");
        user.setWebsiteUrl("http://me.com");
        user.setLocation("Brazil");
        user.setAmountRepositories(20);

        return user;
    }
}
