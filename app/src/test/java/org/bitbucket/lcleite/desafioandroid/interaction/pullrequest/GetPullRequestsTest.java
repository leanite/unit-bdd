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

    PullRequestListPresenterSpy presenter;
    PullRequestDataSource dataSource;
    GetPullRequestsUseCase useCase;
    PullRequestListController controller;
    Repository repository;

    @Before
    public void setup(){
        presenter = new PullRequestListPresenterSpy();
        repository = createRepository();
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
        setupOpenStateRequestDataSource();
        controller.getPullRequests(repository, PullRequest.State.open.value(), 1);

        assertNotEquals(presenter.getPullRequests().size(), 0);
    }

    @Test
    public void itShould_returnNonEmptyClosedPullRequestList(){
        setupClosedStateRequestDataSource();
        controller.getPullRequests(repository, PullRequest.State.closed.value(), 1);

        assertNotEquals(presenter.getPullRequests().size(), 0);
    }

    @Test
    public void itShould_returnOnlyOpenPullRequests(){
        setupOpenStateRequestDataSource();
        controller.getPullRequests(repository, PullRequest.State.open.value(), 1);
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
        controller.getPullRequests(repository, PullRequest.State.closed.value(), 1);
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
