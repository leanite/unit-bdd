package org.bitbucket.lcleite.desafioandroid.ui.app;

import android.app.Application;

import org.bitbucket.lcleite.desafioandroid.injection.ApplicationComponent;
import org.bitbucket.lcleite.desafioandroid.injection.ApplicationModule;
import org.bitbucket.lcleite.desafioandroid.injection.DaggerApplicationComponent;
import org.bitbucket.lcleite.desafioandroid.injection.RepositoryListModule;

/**
 * Created by leandro on 23/12/2017.
 */

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .repositoryListModule(new RepositoryListModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}