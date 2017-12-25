package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;

import org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest.PullRequestDataSource;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest.PullRequestListController;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by leandro on 22/12/2017.
 */

public class GetPullRequestsTest {

    private PullRequestListPresenterSpy presenter;
    private PullRequestDataSource dataSource;
    private GetPullRequestsUseCase useCase;
    private PullRequestListController controller;

    private String repositoryUsername;
    private String repositoryName;

    @Before
    public void setup(){
        presenter = new PullRequestListPresenterSpy();
        repositoryUsername = "elastic";
        repositoryName = "elasticsearch";
    }

    private void setupOpenStateRequestDataSource(){
        dataSource = new PullRequestDataSourceSpy(new GetOpenPullRequestsMockInterceptor());
        setupUseCaseAndController();
    }

    private void setupClosedStateRequestDataSource(){
        dataSource = new PullRequestDataSourceSpy(new GetClosedPullRequestsMockInterceptor());
        setupUseCaseAndController();
    }

    private void setupUseCaseAndController(){
        useCase = new GetPullRequestsUseCaseImpl(dataSource, presenter);
        controller = new PullRequestListController(useCase);
    }

    @Test
    public void itShould_returnNonEmptyOpenPullRequestList(){
        setupOpenStateRequestDataSource();
        controller.getPullRequests(repositoryUsername, repositoryName, PullRequest.State.open, 1);

        assertNotEquals(presenter.getPullRequests().size(), 0);
    }

    @Test
    public void itShould_returnNonEmptyClosedPullRequestList(){
        setupClosedStateRequestDataSource();
        controller.getPullRequests(repositoryUsername, repositoryName, PullRequest.State.closed, 1);

        assertNotEquals(presenter.getPullRequests().size(), 0);
    }

    @Test
    public void itShould_returnOnlyOpenPullRequests(){
        setupOpenStateRequestDataSource();
        controller.getPullRequests(repositoryUsername, repositoryName, PullRequest.State.open, 1);
        List<PullRequest> pullRequests = presenter.getPullRequests();

        assertTrue(allPullRequestsOpen(pullRequests));
    }

    private boolean allPullRequestsOpen(List<PullRequest> pullRequests) {
        for(PullRequest pullRequest : pullRequests){
            if(!pullRequest.isOpen())
                return false;
        }

        return true;
    }

    @Test
    public void itShould_returnOnlyClosedPullRequests(){
        setupClosedStateRequestDataSource();
        controller.getPullRequests(repositoryUsername, repositoryName, PullRequest.State.closed, 1);
        List<PullRequest> pullRequests = presenter.getPullRequests();

        assertTrue(allPullRequestsClosed(pullRequests));
    }

    private boolean allPullRequestsClosed(List<PullRequest> pullRequests) {
        for(PullRequest pullRequest : pullRequests){
            if(pullRequest.isOpen())
                return false;
        }

        return true;
    }
}
