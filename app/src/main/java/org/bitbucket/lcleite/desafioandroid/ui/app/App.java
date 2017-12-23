package org.bitbucket.lcleite.desafioandroid.ui.app;

import android.app.Application;

import org.bitbucket.lcleite.desafioandroid.injection.ApplicationModule;
import org.bitbucket.lcleite.desafioandroid.injection.DaggerRepositoryListComponent;
import org.bitbucket.lcleite.desafioandroid.injection.RepositoryListComponent;
import org.bitbucket.lcleite.desafioandroid.injection.RepositoryListModule;

/**
 * Created by leandro on 23/12/2017.
 */

public class App extends Application {

    private RepositoryListComponent repositoryListComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        repositoryListComponent = DaggerRepositoryListComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .repositoryListModule(new RepositoryListModule())
                .build();
    }

    public RepositoryListComponent getRepositoryListComponent() {
        return repositoryListComponent;
    }
}