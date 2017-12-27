package org.bitbucket.lcleite.desafioandroid.interaction.user;

import org.bitbucket.lcleite.desafioandroid.data.datasource.repository.RepositoryDataSource;
import org.bitbucket.lcleite.desafioandroid.data.datasource.user.UserDataSource;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesUseCase;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesUseCaseImpl;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.RepositoryDataSourceSpy;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.RepositoryListPresenterSpy;
import org.bitbucket.lcleite.desafioandroid.interaction.userdata.GetUserDataUseCase;
import org.bitbucket.lcleite.desafioandroid.interaction.userdata.GetUserDataUseCaseImpl;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.repository.RepositoryListController;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.user.UserDetailsController;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by leandro on 22/12/2017.
 */

public class GetUserTest {

    UserDetailsPresenterSpy presenter;
    UserDataSource dataSource;
    GetUserDataUseCase useCase;
    UserDetailsController controller;

    @Before
    public void setup(){
        presenter = new UserDetailsPresenterSpy();
        dataSource = new UserDataSourceSpy();
        useCase = new GetUserDataUseCaseImpl(dataSource, presenter);
        controller = new UserDetailsController(useCase, null);
    }

    @Test
    public void itShould_returnNonNullUser(){
        controller.getUserDetails("elastic");

        assertNotEquals(presenter.getUser(), null);
    }

    @Test
    public void itShould_returnElasticUser(){
        controller.getUserDetails("elastic");

        assertEquals(presenter.getUser().getUsername(), "elastic");
    }
}
