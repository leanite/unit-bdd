package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;

import org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest.PullRequestDataSource;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest.PullRequestListController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by leandro on 22/12/2017.
 */

public class GetPullRequestsTest {

    PullRequestListPresenterSpy presenter;
    PullRequestDataSource dataSource;
    GetPullRequestsUseCase useCase;
    PullRequestListController controller;
    Repository repository;

    @Before
    public void setup(){
        presenter = new PullRequestListPresenterSpy();
        String state = "open";
        dataSource = new PullRequestDataSourceSpy(state);
        useCase = new GetPullRequestsUseCaseSpy(dataSource, presenter);
        controller = new PullRequestListController(useCase);
        repository = createRepository();
    }

    private Repository createRepository() {
        Repository repository = new Repository();
        User owner = createOwner();

        repository.setOwner(owner);
        repository.setName("elasticsearch");

        return repository;
    }

    private User createOwner() {
        User user = new User();

        user.setUsername("elastic");

        return user;
    }

    @Test
    public void itShould_returnNonEmptyOpenPullRequestList(){
        controller.getPullRequests(repository, "open", 1);

        assertNotEquals(presenter.getPullRequests().size(), 0);
    }

//    @Test
//    public void itShould_returnElasticSearchRepository(){
//        controller.getRepositories(1);
//        List<Repository> repositories = presenter.getRepositories();
//        Repository elasticSearch = repositories.get(2);
//
//        assertEquals("elasticsearch", elasticSearch.getName());
//    }
}
