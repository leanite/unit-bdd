package org.bitbucket.lcleite.desafioandroid.ui;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.bitbucket.lcleite.desafioandroid.R;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.presentation.view.RepositoryListView;
import org.bitbucket.lcleite.desafioandroid.presentation.viewmodel.RepositoryListViewModel;
import org.bitbucket.lcleite.desafioandroid.ui.adapter.RepositoryListAdapter;
import org.bitbucket.lcleite.desafioandroid.ui.divider.ListDivider;

import java.util.List;

import javax.inject.Inject;

@EActivity(R.layout.activity_repositorylist)
public class RepositoryListActivity extends AppCompatActivity implements RepositoryListView {

    @ViewById(R.id.appBar)
    protected Toolbar appBar;

    @ViewById(R.id.refreshContainer)
    protected SwipeRefreshLayout swipeRefresh;

    @ViewById(R.id.rvRepositoryList)
    protected RecyclerView repositoriesRecyclerView;

    RepositoryListViewModel repositoryListViewModel;
    RepositoryListAdapter repositoriesAdapter;

    @AfterViews
    protected void setup(){
        setupAppBar();
        setupRefreshContainer();
        setupViewModel();
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

    private void setupViewModel(){
        repositoryListViewModel = new RepositoryListViewModel();
    }

    private void setupRepositoriesRecyclerViewAdapter(){
        repositoriesAdapter = new RepositoryListAdapter(repositoryListViewModel.getRepositories());
        repositoriesAdapter.setOnItemClickListener(this);
    }

    private void setupRepositoriesRecyclerView() {
        repositoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        repositoriesRecyclerView.setAdapter(repositoriesAdapter);
        repositoriesRecyclerView.addItemDecoration(
                new ListDivider(ContextCompat.getDrawable(this, R.drawable.divider_item_list)));
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onItemClick(int position) {

    }
}
