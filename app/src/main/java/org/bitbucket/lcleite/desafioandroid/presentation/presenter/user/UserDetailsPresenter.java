package org.bitbucket.lcleite.desafioandroid.presentation.presenter.user;

import org.bitbucket.lcleite.desafioandroid.interaction.userdata.GetUserDataOutput;
import org.bitbucket.lcleite.desafioandroid.interaction.userrepository.GetUserRepositoriesOutput;
import org.bitbucket.lcleite.desafioandroid.presentation.view.UserDetailsView;

/**
 * Created by leandro on 26/12/2017.
 */

public interface UserDetailsPresenter extends GetUserDataOutput, GetUserRepositoriesOutput {
    void setView(UserDetailsView view);
}
