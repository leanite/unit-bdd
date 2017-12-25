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
    private String repositoryUsername;
    private String repositoryName;

    public PullRequestListViewModel() {
        pullRequests = new ArrayList<>();
        currentPage = 1;
    }

    public void setRepositoryInfo(String repositoryUsername, String repositoryName){
        this.repositoryUsername = repositoryUsername;
        this.repositoryName = repositoryName;
    }

    public String getRepositoryUsername() {
        return repositoryUsername;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public List<PullRequest> getPullRequests() {
        return pullRequests;
    }

    public void appendPullRequests(List<PullRequest> pullRequests) {
        this.pullRequests.addAll(pullRequests);
    }

    public PullRequest getPullRequestAt(int position) {
        return pullRequests.get(position);
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
