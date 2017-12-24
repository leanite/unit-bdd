package org.bitbucket.lcleite.desafioandroid.injection;


import org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest.PullRequestDataSource;
import org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest.PullRequestNetwork;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsUseCase;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsUseCaseImpl;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsUseCase;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsUseCaseImpl;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest.PullRequestListController;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest.PullRequestMainController;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestListPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestListPresenterImpl;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestMainPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestMainPresenterImpl;
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
    @Named("open")
    public PullRequestListPresenter provideOpenPullRequestListPresenter(){
        return new PullRequestListPresenterImpl();
    }

    @Provides
    @Singleton
    @Named("closed")
    public PullRequestListPresenter provideClosedPullRequestListPresenter(){
        return new PullRequestListPresenterImpl();
    }

    @Provides
    public PullRequestDataSource providePullRequestDataSource(){
        return new PullRequestNetwork();
    }

    @Provides
    @Named("open")
    public GetPullRequestsUseCase provideGetOpenPullRequestsUseCase(PullRequestDataSource dataSource, @Named("open") PullRequestListPresenter presenter){
        return new GetPullRequestsUseCaseImpl(dataSource, presenter);
    }

    @Provides
    @Named("closed")
    public GetPullRequestsUseCase provideGetClosedPullRequestsUseCase(PullRequestDataSource dataSource, @Named("closed") PullRequestListPresenter presenter){
        return new GetPullRequestsUseCaseImpl(dataSource, presenter);
    }

    @Provides
    @Named("open")
    public PullRequestListController provideOpenPullRequestListController(@Named("open") GetPullRequestsUseCase useCase){
        return new PullRequestListController(useCase);
    }

    @Provides
    @Named("closed")
    public PullRequestListController provideClosedPullRequestListController(@Named("closed") GetPullRequestsUseCase useCase){
        return new PullRequestListController(useCase);
    }

    @Provides
    public PullRequestListViewModel providePullRequestListViewModel(){
        return new PullRequestListViewModel();
    }

    @Provides
    public PullRequestMainPresenter providePullRequestMainPresenter(){
        return new PullRequestMainPresenterImpl();
    }

    @Provides
    public GetAmountPullRequestsUseCase provideGetAmountPullRequestsUseCase(PullRequestDataSource dataSource, PullRequestMainPresenter presenter){
        return new GetAmountPullRequestsUseCaseImpl(dataSource, presenter);
    }

    @Provides
    public PullRequestMainController providePullRequestMainController(GetAmountPullRequestsUseCase useCase){
        return new PullRequestMainController(useCase);
    }
}