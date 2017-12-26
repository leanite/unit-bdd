package org.bitbucket.lcleite.desafioandroid.injection;

import org.bitbucket.lcleite.desafioandroid.data.datasource.user.UserDataSource;
import org.bitbucket.lcleite.desafioandroid.data.datasource.user.UserNetwork;
import org.bitbucket.lcleite.desafioandroid.interaction.userdata.GetUserDataUseCase;
import org.bitbucket.lcleite.desafioandroid.interaction.userdata.GetUserDataUseCaseImpl;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.user.UserDetailsController;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.user.UserDetailsPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.user.UserDetailsPresenterImpl;
import org.bitbucket.lcleite.desafioandroid.presentation.viewmodel.UserDetailsViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by leandro on 26/12/2017.
 */

@Module
public class UserDetailsModule {
    @Provides
    @Singleton
    public UserDetailsPresenter provideUserDetailsPresenter(){
        return new UserDetailsPresenterImpl();
    }

    @Provides
    public UserDataSource provideUserDataSource(Retrofit retrofit){
        return new UserNetwork(retrofit);
    }

    @Provides
    public GetUserDataUseCase provideGetUserDataUseCase(UserDataSource dataSource, UserDetailsPresenter presenter){
        return new GetUserDataUseCaseImpl(dataSource, presenter);
    }

    @Provides
    public UserDetailsController provideUserDetailsController(GetUserDataUseCase useCase){
        return new UserDetailsController(useCase);
    }

    @Provides
    public UserDetailsViewModel provideUserDetailsViewModel(){
        return new UserDetailsViewModel();
    }
}