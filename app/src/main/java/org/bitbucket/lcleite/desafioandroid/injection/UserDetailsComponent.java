package org.bitbucket.lcleite.desafioandroid.injection;

import org.bitbucket.lcleite.desafioandroid.ui.UserDetailsActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leandro on 26/12/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, RetrofitModule.class, UserDetailsModule.class})
public interface UserDetailsComponent {
    void inject(UserDetailsActivity target);
}