package org.bitbucket.lcleite.desafioandroid.data.datasource.user;

import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.interaction.UseCaseCallback;
import org.bitbucket.lcleite.desafioandroid.interaction.userdata.GetUserDataOutput;

/**
 * Created by leandro on 26/12/2017.
 */

public interface UserDataSource {
    void getUserDetails(String username,
                        UseCaseCallback<User, GetUserDataOutput.ErrorData> callback);
}
