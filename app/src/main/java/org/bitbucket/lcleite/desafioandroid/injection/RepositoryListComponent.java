package org.bitbucket.lcleite.desafioandroid.injection;

import org.bitbucket.lcleite.desafioandroid.ui.RepositoryListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leandro on 23/12/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, RepositoryListModule.class})
public interface RepositoryListComponent {
    void inject(RepositoryListActivity target);
}