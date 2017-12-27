package org.bitbucket.lcleite.desafioandroid.interaction.user;

import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.interaction.userdata.GetUserDataOutput;

/**
 * Created by leandro on 26/12/2017.
 */

public class UserDetailsPresenterSpy implements GetUserDataOutput {

    private User user;

    public User getUser() {
        return user;
    }

    @Override
    public void onGetUserDataSuccess(User user) {
        this.user = user;
    }

    @Override
    public void onGetUserDataError(ErrorData errorData) {

    }
}
