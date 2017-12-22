package org.bitbucket.lcleite.desafioandroid.data.mapper;

import org.bitbucket.lcleite.desafioandroid.data.model.UserDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.User;

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
    public UserDataModel toDataModel(User entity) {
        return null;
    }
}
