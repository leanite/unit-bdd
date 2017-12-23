package org.bitbucket.lcleite.desafioandroid.injection;

import android.support.v7.app.AppCompatActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leandro on 23/12/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, RepositoryListModule.class})
public interface ApplicationComponent {
    void inject(AppCompatActivity target);
}