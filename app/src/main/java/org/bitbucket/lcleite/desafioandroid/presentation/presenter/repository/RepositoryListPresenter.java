package org.bitbucket.lcleite.desafioandroid.presentation.presenter.repository;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.repository.GetRepositoriesOutput;
import org.bitbucket.lcleite.desafioandroid.presentation.view.RepositoryListView;

/**
 * Created by leandro on 22/12/2017.
 */

public interface RepositoryListPresenter extends GetRepositoriesOutput {
    void setView(RepositoryListView view);
    void goToPullRequestActivity(Repository repository);
}
