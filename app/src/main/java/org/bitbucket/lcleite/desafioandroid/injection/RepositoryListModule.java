package org.bitbucket.lcleite.desafioandroid.injection;

import org.bitbucket.lcleite.desafioandroid.data.datasource.repository.RepositoryDataSource;
import org.bitbucket.lcleite.desafioandroid.data.datasource.repository.RepositoryNetwork;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesUseCase;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesUseCaseImpl;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.repository.RepositoryListController;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.repository.RepositoryListPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.repository.RepositoryListPresenterImpl;
import org.bitbucket.lcleite.desafioandroid.presentation.viewmodel.RepositoryListViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by leandro on 23/12/2017.
 */

@Module
public class RepositoryListModule {
    @Provides
    @Singleton
    public RepositoryListPresenter provideRepositoryListPresenter(){
        return new RepositoryListPresenterImpl();
    }

    @Provides
    public RepositoryDataSource provideRepositoryDataSource(Retrofit retrofit){
        return new RepositoryNetwork(retrofit);
    }

    @Provides
    public GetRepositoriesUseCase provideGetRepositoriesUseCase(RepositoryDataSource dataSource, RepositoryListPresenter presenter){
        return new GetRepositoriesUseCaseImpl(dataSource, presenter);
    }

    @Provides
    public RepositoryListController provideRepositoryListController(GetRepositoriesUseCase useCase){
        return new RepositoryListController(useCase);
    }

    @Provides
    public RepositoryListViewModel provideRepositoryListViewModel(){
        return new RepositoryListViewModel();
    }
}