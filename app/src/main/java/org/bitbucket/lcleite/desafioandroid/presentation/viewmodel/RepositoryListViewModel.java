package org.bitbucket.lcleite.desafioandroid.presentation.viewmodel;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandro on 23/12/2017.
 */

public class RepositoryListViewModel {

    private List<Repository> repositories;
    private int currentPage;

    public RepositoryListViewModel() {
        repositories = new ArrayList<>();
        currentPage = 1;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void appendRepositories(List<Repository> repositories) {
        this.repositories.addAll(repositories);
    }

    public void clearRepositories(){
        this.repositories.clear();
    }

    public Repository getRepositoryAt(int position) {
        return repositories.get(position);
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
