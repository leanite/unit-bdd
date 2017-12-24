package org.bitbucket.lcleite.desafioandroid.injection;


import org.bitbucket.lcleite.desafioandroid.ui.PullRequestListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leandro on 23/12/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, PullRequestListModule.class})
public interface PullRequestListComponent {
    void inject(PullRequestListActivity target);
}