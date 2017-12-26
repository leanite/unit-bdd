package org.bitbucket.lcleite.desafioandroid.interaction.userdata;

import org.bitbucket.lcleite.desafioandroid.data.datasource.user.UserDataSource;
import org.bitbucket.lcleite.desafioandroid.entity.User;

/**
 * Created by leandro on 26/12/2017.
 */

public class GetUserDataUseCaseImpl implements GetUserDataUseCase {

    private UserDataSource userDataSource;
    private GetUserDataOutput userDetailsPresenter;

    public GetUserDataUseCaseImpl(UserDataSource userDataSource, GetUserDataOutput userDetailsPresenter) {
        this.userDataSource = userDataSource;
        this.userDetailsPresenter = userDetailsPresenter;
    }

    @Override
    public void getUserDetails(RequestData requestData) {
        String username = requestData.getUsername();

        userDataSource.getUserDetails(username, this);
    }

    @Override
    public void onSuccess(User responseData) {
        userDetailsPresenter.onGetUserDataSuccess(responseData);
    }

    @Override
    public void onError(GetUserDataOutput.ErrorData errorData) {

    }
}
