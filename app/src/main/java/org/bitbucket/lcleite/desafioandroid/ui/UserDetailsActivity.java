package org.bitbucket.lcleite.desafioandroid.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;
import org.bitbucket.lcleite.desafioandroid.R;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.user.UserDetailsController;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.user.UserDetailsPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.view.UserDetailsView;
import org.bitbucket.lcleite.desafioandroid.presentation.viewmodel.UserDetailsViewModel;
import org.bitbucket.lcleite.desafioandroid.ui.adapter.RepositoryListAdapter;
import org.bitbucket.lcleite.desafioandroid.ui.app.App;
import org.bitbucket.lcleite.desafioandroid.ui.divider.ListDivider;
import org.bitbucket.lcleite.desafioandroid.ui.scroll.EndlessScrollListener;

import javax.inject.Inject;

@EActivity(R.layout.activity_user_details)
public class UserDetailsActivity extends AppCompatActivity implements UserDetailsView {

    public static final String ARGS = "org.bitbucket.lcleite.UserDetailsActivity.ARGS";
    public static final String USER_USERNAME = "org.bitbucket.lcleite.UserDetailsActivity.USER_USERNAME";

    @ViewById(R.id.appBar) protected Toolbar appBar;
    @ViewById(R.id.appBarLayout) protected AppBarLayout appBarLayout;
    @ViewById(R.id.rvRepositoryList) protected RecyclerView repositoriesRecyclerView;
    @ViewById(R.id.tvUsername) protected TextView tvUsername;

    @Inject UserDetailsPresenter userDetailsPresenter;
    @Inject UserDetailsViewModel userDetailsViewModel;
    @Inject UserDetailsController userDetailsController;

    @Extra(ARGS) Bundle intentArgs;

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
        ((App) getApplication()).getUserDetailsComponent().inject(this);
    }

    private void setupViews(){
        setupAppBar();
        setupAppBarLayout();
        setupRepositoriesRecyclerViewAdapter();
        setupRepositoriesRecyclerView();
    }

    private void setupAppBar() {
//        appBar.setTitle(getAppBarTitle());
//        setSupportActionBar(appBar);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupAppBarLayout() {
        appBarLayout.addOnOffsetChangedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    private void setupRepositoriesRecyclerViewAdapter(){
        repositoriesAdapter = new RepositoryListAdapter(userDetailsViewModel.getRepositories());
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
        userDetailsPresenter.setView(this);
    }

    private void onSetupDone(){
        String username = intentArgs.getString(USER_USERNAME);

        userDetailsController.getUserDetails(username);
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onUserAvatarClick(int position) {

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (userDetailsViewModel.getScrollRange() == -1) { //FIXME: ?
            userDetailsViewModel.setScrollRange(appBarLayout.getTotalScrollRange());
        }

        if (appBarLayoutIsCollapsed(verticalOffset))
            appBar.setBackgroundColor(ContextCompat.getColor(UserDetailsActivity.this, R.color.colorPrimary));
        else
            appBar.setBackgroundColor(ContextCompat.getColor(UserDetailsActivity.this, android.R.color.transparent));
    }

    private boolean appBarLayoutIsCollapsed(int verticalOffset) {
        return userDetailsViewModel.getScrollRange() + verticalOffset == 0;
    }

    @Override
    public void endlessLoadMoreItems() {

    }

    @Override
    public void updateUiWithUserDetails(User user) {
        tvUsername.setText(user.getUsername());
    }
}
