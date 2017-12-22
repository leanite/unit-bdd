package org.bitbucket.lcleite.desafioandroid.interaction.repository;

import org.bitbucket.lcleite.desafioandroid.data.datasource.repository.RepositoryDataSource;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.repository.RepositoryListController;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by leandro on 22/12/2017.
 */

public class GetRepositoriesTest {

    RepositoryListPresenterSpy presenter;
    RepositoryDataSource dataSource;
    GetRepositoriesUseCase useCase;
    RepositoryListController controller;

    @Before
    public void setup(){
        presenter = new RepositoryListPresenterSpy();
        dataSource = new RepositoryDataSourceSpy();
        useCase = new GetRepositoriesUseCaseSpy(dataSource, presenter);
        controller = new RepositoryListController(useCase);
    }

    @Test
    public void itShould_returnNonEmptyRepositoryList(){
        controller.getRepositories(1);

        assertNotEquals(presenter.getRepositories().size(), 0);
    }

    @Test
    public void itShould_returnElasticSearchRepository(){
        controller.getRepositories(1);
        List<Repository> repositories = presenter.getRepositories();
        Repository elasticSearch = repositories.get(2);

        assertEquals("elasticsearch", elasticSearch.getName());
    }
}
