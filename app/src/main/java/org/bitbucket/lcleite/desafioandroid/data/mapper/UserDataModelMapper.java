package org.bitbucket.lcleite.desafioandroid.data.mapper;

import org.bitbucket.lcleite.desafioandroid.data.model.UserDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.User;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public class UserDataModelMapper implements DataModelMapper<User, UserDataModel> {

    @Override
    public User toEntity(UserDataModel dataModel) {
        User user = new User();

        user.setId(dataModel.getId());
        user.setUsername(dataModel.getUsername());
        user.setName(dataModel.getName());
        user.setAvatarUrl(dataModel.getAvatarUrl());

        return user;
    }

    @Override
    public List<User> toEntityList(List<UserDataModel> dataModels) {
        return null;
    }

    @Override
    public UserDataModel toDataModel(User entity) {
        return null;
    }

    @Override
    public List<UserDataModel> toDataModelList(List<User> entity) {
        return null;
    }
}
