package org.bitbucket.lcleite.desafioandroid.presentation.presenter.user;

import android.content.Context;
import android.util.Log;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.interaction.userdata.GetUserDataOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.userrepository.GetUserRepositoriesOutput;
import org.bitbucket.lcleite.desafioandroid.presentation.view.UserDetailsView;

import java.util.List;

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
        userView.updateUiWithUserDetails(user);
    }

    @Override
    public void onGetUserDataError(GetUserDataOutput.ErrorData errorData) {

    }

    @Override
    public void onGetUserRepositoriesSuccess(List<Repository> repositories) {
        userView.updateUiWithUserRepositories(repositories);
    }

    @Override
    public void onGetUserRepositoriesError(GetUserRepositoriesOutput.ErrorData errorData) {

    }
}
