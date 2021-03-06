package org.bitbucket.lcleite.desafioandroid.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;
import org.bitbucket.lcleite.desafioandroid.R;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.user.UserDetailsController;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.user.UserDetailsPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.view.UserDetailsView;
import org.bitbucket.lcleite.desafioandroid.presentation.viewmodel.UserDetailsViewModel;
import org.bitbucket.lcleite.desafioandroid.ui.adapter.UserRepositoryListAdapter;
import org.bitbucket.lcleite.desafioandroid.ui.app.App;
import org.bitbucket.lcleite.desafioandroid.ui.divider.ListDivider;
import org.bitbucket.lcleite.desafioandroid.ui.scroll.EndlessScrollListener;

import java.util.List;

import javax.inject.Inject;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

@EActivity(R.layout.activity_user_details)
public class UserDetailsActivity extends AppCompatActivity implements UserDetailsView {

    public static final String ARGS = "org.bitbucket.lcleite.UserDetailsActivity.ARGS";
    public static final String USER_USERNAME = "org.bitbucket.lcleite.UserDetailsActivity.USER_USERNAME";

    @ViewById(R.id.appBar) protected Toolbar appBar;
    @ViewById(R.id.appBarLayout) protected AppBarLayout appBarLayout;
    @ViewById(R.id.rvRepositoryList) protected RecyclerView repositoriesRecyclerView;
    @ViewById(R.id.ivUserProfile) protected ImageView ivUserProfilePicture;
    @ViewById(R.id.tvUsername) protected TextView tvUsername;
    @ViewById(R.id.tvName) protected TextView tvName;
    @ViewById(R.id.tvWebsite) protected TextView tvWebsite;
    @ViewById(R.id.tvLocation) protected TextView tvLocation;

    @Inject UserDetailsPresenter userDetailsPresenter;
    @Inject UserDetailsViewModel userDetailsViewModel;
    @Inject UserDetailsController userDetailsController;

    @Extra(ARGS) Bundle intentArgs;

    UserRepositoryListAdapter repositoriesAdapter;
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
        appBar.setTitle(getResources().getText(R.string.repositories));
        setSupportActionBar(appBar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        repositoriesAdapter = new UserRepositoryListAdapter(userDetailsViewModel.getRepositories());
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
        userDetailsController.getUserRepositories(username, userDetailsViewModel.getCurrentPage());
    }

    @Override
    public void updateUiWithUserDetails(User user) {
        saveUserData(user);
        loadProfileImage(user);
        updateTextViews(user);
    }

    private void saveUserData(User user) {
        userDetailsViewModel.setUser(user);
    }

    private void loadProfileImage(User user) {
        Picasso.with(this)
                .load(user.getAvatarUrl())
                .placeholder(R.drawable.downloading_placeholder)
                .error(R.drawable.downloading_error)
                .resizeDimen(R.dimen.profile_pic_large, R.dimen.profile_pic_large)
                .transform(new CropCircleTransformation())
                .into(ivUserProfilePicture);
    }

    private void updateTextViews(User user) {
        tvUsername.setText(user.getUsername());
        tvName.setText(user.getName());
        ifNullShowDefault(user.getWebsiteUrl(), tvWebsite);
        ifNullShowDefault(user.getLocation(), tvLocation);
    }

    private void ifNullShowDefault(String field, TextView textView) {
        if(field != null)
            textView.setText(field);
        else
            textView.setText(getResources().getText(R.string.empty_field));
    }

    @Override
    public void updateUiWithUserRepositories(List<Repository> repositories) {
        userDetailsViewModel.appendRepositories(repositories);
        repositoriesAdapter.notifyDataSetChanged();
    }

    @Override
    public void endlessLoadMoreItems() {
        userDetailsViewModel.incrementPage();
        getUserRepositories();
    }

    private void getUserRepositories() {
        String username = userDetailsViewModel.getUser().getUsername();
        int currentPage = userDetailsViewModel.getCurrentPage();

        userDetailsController.getUserRepositories(username, currentPage);
    }

    @Override
    public void showErrorMessage(String message) {
        Snackbar.make(repositoriesRecyclerView, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void updateUiAfterError() {}

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int scrollRange = appBarLayout.getTotalScrollRange();

        if (appBarLayoutIsCollapsed(scrollRange, verticalOffset))
            appBar.setBackgroundColor(ContextCompat.getColor(UserDetailsActivity.this, R.color.colorPrimary));
        else
            appBar.setBackgroundColor(ContextCompat.getColor(UserDetailsActivity.this, android.R.color.transparent));
    }

    private boolean appBarLayoutIsCollapsed(int scrollRange, int verticalOffset) {
        return scrollRange + verticalOffset == 0;
    }
}
