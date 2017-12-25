package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.amount;

import org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest.PullRequestDataSource;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsUseCase;
import org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest.GetAmountPullRequestsUseCaseImpl;
import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.PullRequestDataSourceSpy;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest.PullRequestMainController;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by leandro on 22/12/2017.
 */

public class GetAmountPullRequestsTest {

    PullRequestMainPresenterSpy presenter;
    PullRequestDataSource dataSource;
    GetAmountPullRequestsUseCase useCase;
    PullRequestMainController controller;
    Repository repository;

    @Before
    public void setup(){
        presenter = new PullRequestMainPresenterSpy();
        repository = createRepository();
        dataSource = new PullRequestDataSourceSpy(new GetAmountPullRequestsMockInterceptor());
        useCase = new GetAmountPullRequestsUseCaseImpl(dataSource, presenter);
        controller = new PullRequestMainController(useCase);
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
    public void itShould_returnNonZeroPullRequestAmount(){
        controller.getAmountPullRequestsUseCase(repository, PullRequest.State.open);

        assertNotEquals(presenter.getAmountPullRequests(), 0);
    }

    @Test
    public void itShould_return125PullRequestAmount(){
        controller.getAmountPullRequestsUseCase(repository, PullRequest.State.open);

        assertEquals(presenter.getAmountPullRequests(), 125);
    }

    @Test
    public void itShould_returnTheSamePullRequestState(){
        controller.getAmountPullRequestsUseCase(repository, PullRequest.State.open);

        assertEquals(presenter.getState(), PullRequest.State.open);
    }
}
