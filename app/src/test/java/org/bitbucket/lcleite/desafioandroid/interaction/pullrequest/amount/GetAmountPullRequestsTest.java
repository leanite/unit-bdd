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

    private PullRequestMainPresenterSpy presenter;
    private PullRequestDataSource dataSource;
    private GetAmountPullRequestsUseCase useCase;
    private PullRequestMainController controller;

    private String repositoryUsername;
    private String repositoryName;

    @Before
    public void setup(){
        presenter = new PullRequestMainPresenterSpy();
        dataSource = new PullRequestDataSourceSpy(new GetAmountPullRequestsMockInterceptor());
        useCase = new GetAmountPullRequestsUseCaseImpl(dataSource, presenter);
        controller = new PullRequestMainController(useCase);
        repositoryUsername = "elastic";
        repositoryName = "elasticsearch";
    }

    @Test
    public void itShould_returnNonZeroPullRequestAmount(){
        controller.getAmountPullRequestsUseCase(repositoryUsername, repositoryName, PullRequest.State.open);

        assertNotEquals(presenter.getAmountPullRequests(), 0);
    }

    @Test
    public void itShould_return125PullRequestAmount(){
        controller.getAmountPullRequestsUseCase(repositoryUsername, repositoryName, PullRequest.State.open);

        assertEquals(presenter.getAmountPullRequests(), 125);
    }

    @Test
    public void itShould_returnTheSamePullRequestState(){
        controller.getAmountPullRequestsUseCase(repositoryUsername, repositoryName, PullRequest.State.open);

        assertEquals(presenter.getState(), PullRequest.State.open);
    }
}
