package org.bitbucket.lcleite.desafioandroid.ui.app;

import android.app.Application;

import org.bitbucket.lcleite.desafioandroid.injection.ApplicationModule;
import org.bitbucket.lcleite.desafioandroid.injection.DaggerPullRequestListComponent;
import org.bitbucket.lcleite.desafioandroid.injection.DaggerRepositoryListComponent;
import org.bitbucket.lcleite.desafioandroid.injection.PullRequestListComponent;
import org.bitbucket.lcleite.desafioandroid.injection.PullRequestListModule;
import org.bitbucket.lcleite.desafioandroid.injection.RepositoryListComponent;
import org.bitbucket.lcleite.desafioandroid.injection.RepositoryListModule;
import org.bitbucket.lcleite.desafioandroid.injection.RetrofitModule;

/**
 * Created by leandro on 23/12/2017.
 */

public class App extends Application {

    private RepositoryListComponent repositoryListComponent;
    private PullRequestListComponent pullRequestListComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        repositoryListComponent = DaggerRepositoryListComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .retrofitModule(new RetrofitModule())
                .repositoryListModule(new RepositoryListModule())
                .build();

        pullRequestListComponent = DaggerPullRequestListComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .retrofitModule(new RetrofitModule())
                .pullRequestListModule(new PullRequestListModule())
                .build();
    }

    public RepositoryListComponent getRepositoryListComponent() {
        return repositoryListComponent;
    }

    public PullRequestListComponent getPullRequestListComponent(){
        return pullRequestListComponent;
    }
}