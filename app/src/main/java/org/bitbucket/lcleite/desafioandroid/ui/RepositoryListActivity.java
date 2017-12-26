package org.bitbucket.lcleite.desafioandroid.ui;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.bitbucket.lcleite.desafioandroid.R;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.repository.RepositoryListController;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.repository.RepositoryListPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.view.RepositoryListView;
import org.bitbucket.lcleite.desafioandroid.presentation.viewmodel.RepositoryListViewModel;
import org.bitbucket.lcleite.desafioandroid.ui.adapter.RepositoryListAdapter;
import org.bitbucket.lcleite.desafioandroid.ui.app.App;
import org.bitbucket.lcleite.desafioandroid.ui.divider.ListDivider;
import org.bitbucket.lcleite.desafioandroid.ui.scroll.EndlessScrollListener;

import java.util.List;

import javax.inject.Inject;

@EActivity(R.layout.activity_repository_list)
public class RepositoryListActivity extends AppCompatActivity implements RepositoryListView {

    @ViewById(R.id.appBar) protected Toolbar appBar;
    @ViewById(R.id.refreshContainer) protected SwipeRefreshLayout swipeRefresh;
    @ViewById(R.id.rvRepositoryList) protected RecyclerView repositoriesRecyclerView;

    @Inject protected RepositoryListController repositoryListController;
    @Inject protected RepositoryListPresenter repositoryListPresenter;
    @Inject protected RepositoryListViewModel repositoryListViewModel;

    RepositoryListAdapter repositoriesAdapter;
    EndlessScrollListener endlessScrollListener;

    @AfterViews
    protected void setup(){
        setupInjection();
        setupViews();
        setupPresenters();
        onSetupDone();
    }

    private void setupInjection(){
        ((App) getApplication()).getRepositoryListComponent().inject(this);
    }

    private void setupViews(){
        setupAppBar();
        setupRefreshContainer();
        setupRepositoriesRecyclerViewAdapter();
        setupRepositoriesRecyclerView();
    }

    private void setupAppBar() {
        appBar.setTitle(R.string.app_name);
        setSupportActionBar(appBar);
    }

    private void setupRefreshContainer() {
        swipeRefresh.setOnRefreshListener(this);
        swipeRefresh.setColorSchemeColors(
                ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.colorAccent)
        );
    }

    private void setupRepositoriesRecyclerViewAdapter(){
        repositoriesAdapter = new RepositoryListAdapter(repositoryListViewModel.getRepositories());
        repositoriesAdapter.setOnItemClickListener(this);
    }

    private void setupRepositoriesRecyclerView() {
        endlessScrollListener = new EndlessScrollListener(this);
        repositoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        repositoriesRecyclerView.setAdapter(repositoriesAdapter);
        repositoriesRecyclerView.addItemDecoration(
                new ListDivider(ContextCompat.getDrawable(this, R.drawable.divider_item_list)));
        repositoriesRecyclerView.addOnScrollListener(endlessScrollListener);
    }

    private void setupPresenters(){
        repositoryListPresenter.setView(this);
    }

    private void onSetupDone() {
        getRepositories();
    }

    @Override
    public void onRefresh() {
        repositoryListViewModel.resetPage();
        repositoryListViewModel.clearRepositories();
        endlessScrollListener.reset();
        getRepositories();
    }

    @Override
    public void onItemClick(int position) {
        Repository repository = repositoryListViewModel.getRepositoryAt(position);

        repositoryListPresenter.goToPullRequestActivity(repository);
    }

    @Override
    public void endlessLoadMoreItems() {
        repositoryListViewModel.incrementPage();
        getRepositories();
    }

    @Override
    public void updateRepositories(List<Repository> repositories) {
        repositoryListViewModel.appendRepositories(repositories);
    }

    @Override
    public void updateUiAfterQuery() {
        swipeRefresh.setRefreshing(false);
        repositoriesAdapter.notifyDataSetChanged();
    }

    private void getRepositories(){
        swipeRefresh.setRefreshing(true);
        repositoryListController.getRepositories(repositoryListViewModel.getCurrentPage());
    }
}
