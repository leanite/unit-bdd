package org.bitbucket.lcleite.desafioandroid.ui;

import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;
import org.bitbucket.lcleite.desafioandroid.R;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest.PullRequestListController;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest.PullRequestMainController;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestListPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestMainPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.view.PullRequestMainView;
import org.bitbucket.lcleite.desafioandroid.ui.app.App;
import org.bitbucket.lcleite.desafioandroid.ui.fragment.ClosedPullRequestListFragment;
import org.bitbucket.lcleite.desafioandroid.ui.fragment.OpenPullRequestListFragment;

import javax.inject.Inject;
import javax.inject.Named;

@EActivity(R.layout.activity_pull_request_list)
public class PullRequestListActivity extends AppCompatActivity implements PullRequestMainView {
    public static final String ARGS = "org.bitbucket.lcleite.PullRequestListActivity.ARGS";
    public static final String REPOSITORY_USERNAME = "org.bitbucket.lcleite.PullRequestListActivity.REPOSITORY_USERNAME";
    public static final String REPOSITORY_NAME = "org.bitbucket.lcleite.PullRequestListActivity.REPOSITORY_NAME";

    private static final int OPEN_TAB = 0;
    private static final int CLOSED_TAB = 1;

    @Inject @Named("open") protected PullRequestListController openPullRequestListController;
    @Inject @Named("open") protected PullRequestListPresenter openPullRequestListPresenter;
    @Inject @Named("closed") protected PullRequestListController closedPullRequestListController;
    @Inject @Named("closed") protected PullRequestListPresenter closedPullRequestListPresenter;
    @Inject protected PullRequestMainController pullRequestMainController;
    @Inject protected PullRequestMainPresenter pullRequestMainPresenter;

    @ViewById(R.id.appBar) protected Toolbar appBar;
    @ViewById(R.id.tabViewPager) protected ViewPager tabViewPager;
    @ViewById(R.id.tabBar) protected TabLayout tabBar;
    @ViewById(R.id.openTabItem) protected TabItem openTabTitle;
    @ViewById(R.id.closedTabItem) protected TabItem closedTabTitle;

    @Extra(ARGS) Bundle intentArgs;

    private TabPagerAdapter tabPagerAdapter;

    @AfterViews
    protected void setup(){
        setupInjection();
        setupAppBar();
        setupTabBar();
        setupPresenters();
        onSetupDone();
    }

    private void setupInjection(){
        ((App) getApplication()).getPullRequestListComponent().inject(this);
    }

    private void setupAppBar() {
        appBar.setTitle(getAppBarTitle());
        setSupportActionBar(appBar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private String getAppBarTitle() {
        final int lengthLimit = 20;
        final int maxLength = 15;
        String repositoryName = intentArgs.getString(REPOSITORY_NAME);

        if(repositoryName.length() >= lengthLimit)
            repositoryName = repositoryName.substring(0, maxLength) + "...";

        return repositoryName + " Pull Requests";
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

    private void setupTabBar(){
        tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());

        tabViewPager.setAdapter(tabPagerAdapter);
        tabViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabBar));

        tabBar.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(tabViewPager));
    }

    private void setupPresenters(){
        pullRequestMainPresenter.setView(this);
    }

    private void onSetupDone(){
        String username = intentArgs.getString(REPOSITORY_USERNAME);
        String name = intentArgs.getString(REPOSITORY_NAME);

        pullRequestMainController.getAmountPullRequestsUseCase(username, name, PullRequest.State.open);
        pullRequestMainController.getAmountPullRequestsUseCase(username, name, PullRequest.State.closed);
    }

    @Override
    public void updateAmountOpenPullRequests(int amountPullRequests) {
        String valueText = String.valueOf(amountPullRequests);

        updateTabTitle(OPEN_TAB, "Open: "+valueText);
    }

    @Override
    public void updateAmountClosedPullRequests(int amountPullRequests) {
        String valueText = String.valueOf(amountPullRequests);

        updateTabTitle(CLOSED_TAB, "Closed: "+valueText);
    }

    private void updateTabTitle(int position, String newTitle){
        tabBar.getTabAt(position).setText(newTitle);
        tabPagerAdapter.notifyDataSetChanged();
    }

    public class TabPagerAdapter extends FragmentPagerAdapter {

        public TabPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0)
                return OpenPullRequestListFragment.newInstance(openPullRequestListPresenter, openPullRequestListController, intentArgs);
            else
                return ClosedPullRequestListFragment.newInstance(closedPullRequestListPresenter, closedPullRequestListController, intentArgs);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
