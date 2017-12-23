package org.bitbucket.lcleite.desafioandroid.presentation.viewmodel;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandro on 23/12/2017.
 */

public class RepositoryListViewModel {

    private List<Repository> repositories;

    public RepositoryListViewModel() {
        repositories = new ArrayList<>();
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories.clear();
        this.repositories.addAll(repositories);
    }
}
