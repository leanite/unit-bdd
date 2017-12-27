package org.bitbucket.lcleite.desafioandroid.interaction.repository;

import org.bitbucket.lcleite.desafioandroid.data.datasource.repository.RepositoryDataSource;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.userrepository.GetUserRepositoriesUseCase;
import org.bitbucket.lcleite.desafioandroid.interaction.userrepository.GetUserRepositoriesUseCaseImpl;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.user.UserDetailsController;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by leandro on 26/12/2017.
 */

public class GetUserRepositoriesTest {

    RepositoryListPresenterSpy presenter;
    RepositoryDataSource dataSource;
    GetUserRepositoriesUseCase useCase;
    UserDetailsController controller;

    @Before
    public void setup(){
        presenter = new RepositoryListPresenterSpy();
        dataSource = new UserRepositoryDataSourceSpy();
        useCase = new GetUserRepositoriesUseCaseImpl(dataSource, presenter);
        controller = new UserDetailsController(null, useCase);
    }

    @Test
    public void itShould_returnNonEmptyRepositoryList(){
        controller.getUserRepositories("elastic",1);

        assertNotEquals(presenter.getRepositories().size(), 0);
    }

    @Test
    public void itShould_returnElasticSearchRepository(){
        controller.getUserRepositories("elastic", 1);
        List<Repository> repositories = presenter.getRepositories();
        Repository ansibleBeats = repositories.get(1);

        assertEquals("ansible-beats", ansibleBeats.getName());
    }
}
