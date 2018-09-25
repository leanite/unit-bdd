package org.bitbucket.lcleite.desafioandroid.bdd;

import org.bitbucket.lcleite.desafioandroid.data.datasource.repository.RepositoryDataSource;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesUseCase;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesUseCaseImpl;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.RepositoryDataSourceSpy;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.RepositoryListPresenterSpy;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.repository.RepositoryListController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class Testy {

    RepositoryListPresenterSpy presenter;
    RepositoryDataSourceNoRetrofit dataSource;
    GetRepositoriesUseCase useCase;
    RepositoryListController controller;

    @Before
    public void setup(){
        presenter = new RepositoryListPresenterSpy();
        dataSource = new RepositoryDataSourceNoRetrofit();
        useCase = new GetRepositoriesUseCaseImpl(dataSource, presenter);
        controller = new RepositoryListController(useCase);
    }

    @Test
    public void itShould_returnNonEmptyRepositoryList(){
        controller.getRepositories(1);

        assertNotEquals(presenter.getRepositories().size(), 0);
    }
}
