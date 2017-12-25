package org.bitbucket.lcleite.desafioandroid.ui;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.bitbucket.lcleite.desafioandroid.R;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest.PullRequestListController;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest.PullRequestMainController;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestListPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestMainPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.view.PullRequestMainView;
import org.bitbucket.lcleite.desafioandroid.ui.app.App;
import org.bitbucket.lcleite.desafioandroid.ui.fragment.ClosedPullRequestListFragment;
import org.bitbucket.lcleite.desafioandroid.ui.fragment.OpenPullRequestListFragment;
import org.bitbucket.lcleite.desafioandroid.ui.fragment.PullRequestListFragment;

import javax.inject.Inject;
import javax.inject.Named;

@EActivity(R.layout.activity_pullrequestlist)
public class PullRequestListActivity extends AppCompatActivity implements PullRequestMainView {

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
        appBar.setTitle(R.string.app_name);
        setSupportActionBar(appBar);
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
        pullRequestMainController.getAmountPullRequestsUseCase(createMockRepository(), PullRequest.State.open);
        pullRequestMainController.getAmountPullRequestsUseCase(createMockRepository(), PullRequest.State.closed);
    }

    //FIXME: remove mock
    private Repository createMockRepository() {
        Repository repository = new Repository();
        User owner = new User();

        owner.setUsername("elastic");
        repository.setOwner(owner);
        repository.setName("elasticsearch");

        return repository;
    }

    //FIXME: improve code
    @Override
    public void updateAmountOpenPullRequests(int amountPullRequests) {
        String valueText = String.valueOf(amountPullRequests);
        Log.d("OK", valueText);
        tabBar.getTabAt(0).setText("Open: "+valueText);
        tabPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateAmountClosedPullRequests(int amountPullRequests) {
        String valueText = String.valueOf(amountPullRequests);
        Log.d("OK", valueText);
        tabBar.getTabAt(1).setText("Closed: "+valueText);
        tabPagerAdapter.notifyDataSetChanged();
    }

    public class TabPagerAdapter extends FragmentPagerAdapter {

        public TabPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0)
                return OpenPullRequestListFragment.newInstance(openPullRequestListPresenter, openPullRequestListController);
            else
                return ClosedPullRequestListFragment.newInstance(closedPullRequestListPresenter, closedPullRequestListController);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
