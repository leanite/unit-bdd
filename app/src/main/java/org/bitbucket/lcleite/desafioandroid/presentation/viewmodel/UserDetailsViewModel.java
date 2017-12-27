package org.bitbucket.lcleite.desafioandroid.presentation.viewmodel;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandro on 26/12/2017.
 */

public class UserDetailsViewModel {

    private User user;
    private List<Repository> repositories;
    private int currentPage;

    public UserDetailsViewModel() {
        repositories = new ArrayList<>();
        currentPage = 1;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void appendRepositories(List<Repository> repositories) {
        this.repositories.addAll(repositories);
    }

    public void incrementPage(){
        currentPage += 1;
    }

    public int getCurrentPage(){
        return currentPage;
    }
}
