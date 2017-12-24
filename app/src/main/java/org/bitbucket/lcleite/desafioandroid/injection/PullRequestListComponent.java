package org.bitbucket.lcleite.desafioandroid.injection;


import org.bitbucket.lcleite.desafioandroid.ui.PullRequestListActivity;
import org.bitbucket.lcleite.desafioandroid.ui.fragment.PullRequestListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leandro on 23/12/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, PullRequestListModule.class})
public interface PullRequestListComponent {
    void inject(PullRequestListFragment target);
    void inject(PullRequestListActivity target);
}