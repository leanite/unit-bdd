package org.bitbucket.lcleite.desafioandroid.injection;


import org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest.PullRequestDataSource;
import org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest.PullRequestNetwork;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsUseCase;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsUseCaseImpl;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest.PullRequestListController;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestListPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestListPresenterImpl;
import org.bitbucket.lcleite.desafioandroid.presentation.viewmodel.PullRequestListViewModel;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leandro on 23/12/2017.
 */

@Module
public class PullRequestListModule {
    @Provides
    @Singleton
    public PullRequestListPresenter provideOpenPullRequestListPresenter(){
        return new PullRequestListPresenterImpl();
    }

    @Provides
    public PullRequestDataSource providePullRequestDataSource(){
        return new PullRequestNetwork();
    }

    @Provides
    public GetPullRequestsUseCase provideGetPullRequestsUseCase(PullRequestDataSource dataSource, PullRequestListPresenter presenter){
        return new GetPullRequestsUseCaseImpl(dataSource, presenter);
    }

    @Provides
    public PullRequestListController providePullRequestListController(GetPullRequestsUseCase useCase){
        return new PullRequestListController(useCase);
    }

    @Provides
    public PullRequestListViewModel providePullRequestListViewModel(){
        return new PullRequestListViewModel();
    }
}