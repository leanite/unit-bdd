package org.bitbucket.lcleite.desafioandroid.presentation.presenter.user;

import android.content.Context;

import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.presentation.view.UserDetailsView;

/**
 * Created by leandro on 26/12/2017.
 */

public class UserDetailsPresenterImpl implements UserDetailsPresenter {

    private UserDetailsView userView;
    private Context context;

    @Override
    public void setView(UserDetailsView view) {
        userView = view;
        context = (Context) view;
    }

    @Override
    public void onGetUserDataSuccess(User user) {

    }

    @Override
    public void onGetUserDataError(ErrorData errorData) {

    }
}
