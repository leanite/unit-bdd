package org.bitbucket.lcleite.desafioandroid.viewmodel;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.presentation.viewmodel.RepositoryListViewModel;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by leandro on 22/12/2017.
 */

public class RepositoryListViewModelTest {

    RepositoryListViewModel viewModel;

    @Before
    public void setup(){
        viewModel = new RepositoryListViewModel();
        viewModel.appendRepositories(createRepositoryListMock());
        viewModel.incrementPage();
    }

    @Test
    public void itShould_appendRepositories(){
        viewModel.appendRepositories(createRepositoryListMock());

        assertEquals(viewModel.getRepositories().size(), 6);
    }

    @Test
    public void itShould_clearAllRepositories(){
        viewModel.clearRepositories();

        assertEquals(viewModel.getRepositories().size(), 0);
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

    private List<Repository> createRepositoryListMock(){
        List<Repository> repositories = new ArrayList<>();

        repositories.add(new Repository());
        repositories.add(new Repository());
        repositories.add(new Repository());

        return repositories;
    }
}
