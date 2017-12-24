package org.bitbucket.lcleite.desafioandroid.presentation.viewmodel;


import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandro on 23/12/2017.
 */

public class PullRequestListViewModel {

    private List<PullRequest> pullRequests;
    private int currentPage;

    public PullRequestListViewModel() {
        pullRequests = new ArrayList<>();
        currentPage = 1;
    }

    public List<PullRequest> getPullRequests() {
        return pullRequests;
    }

    public void appendPullRequests(List<PullRequest> pullRequests) {
        this.pullRequests.addAll(pullRequests);
    }

    public void clearPullRequests(){
        this.pullRequests.clear();
    }

    public void incrementPage(){
        currentPage += 1;
    }

    public int getCurrentPage(){
        return currentPage;
    }

    public void resetPage(){
        currentPage = 1;
    }
}
