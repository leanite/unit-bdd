package org.bitbucket.lcleite.desafioandroid.viewmodel;

import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.presentation.viewmodel.PullRequestListViewModel;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by leandro on 23/12/2017.
 */

public class PullRequestListViewModelTest {

    private PullRequestListViewModel viewModel;

    @Before
    public void setup(){
        viewModel = new PullRequestListViewModel();
        viewModel.appendPullRequests(createPullRequestListMock());
        viewModel.incrementPage();
    }

    @Test
    public void itShould_appendPullRequests(){
        viewModel.appendPullRequests(createPullRequestListMock());

        assertEquals(viewModel.getPullRequests().size(), 6);
    }

    @Test
    public void itShould_clearAllPullRequests(){
        viewModel.clearPullRequests();

        assertEquals(viewModel.getPullRequests().size(), 0);
    }

    @Test
    public void itShould_incrementCurrentPage(){
        viewModel.incrementPage();

        assertEquals(viewModel.getCurrentPage(), 3);
    }

    @Test
    public void itShould_resetToPageOne(){
        viewModel.resetPage();

        assertEquals(viewModel.getCurrentPage(), 1);
    }

    private List<PullRequest> createPullRequestListMock(){
        List<PullRequest> pullRequests = new ArrayList<>();

        pullRequests.add(new PullRequest());
        pullRequests.add(new PullRequest());
        pullRequests.add(new PullRequest());

        return pullRequests;
    }
}
