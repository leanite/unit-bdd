package org.bitbucket.lcleite.desafioandroid.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.bitbucket.lcleite.desafioandroid.R;
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

    @Inject @Named("open") PullRequestListController openPullRequestListController; //FIXME: private
    @Inject @Named("open") PullRequestListPresenter openPullRequestListPresenter;
    @Inject @Named("closed") PullRequestListController closedPullRequestListController; //FIXME: private
    @Inject @Named("closed") PullRequestListPresenter closedPullRequestListPresenter;
    @Inject PullRequestMainController pullRequestMainController;
    @Inject PullRequestMainPresenter pullRequestMainPresenter;

    @ViewById(R.id.appBar) protected Toolbar appBar;
    @ViewById(R.id.tabViewPager) protected ViewPager tabViewPager;
    @ViewById(R.id.tabBar) protected TabLayout tabBar;

    private TabPagerAdapter tabPagerAdapter;

    @AfterViews
    protected void setup(){
        setupInjection();
        setupAppBar();
        setupTabBar();
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

    private void onSetupDone(){
        pullRequestMainController.getAmountPullRequestsUseCase(createMockRepository(), "open");
        pullRequestMainController.getAmountPullRequestsUseCase(createMockRepository(), "closed");
    }

    @Override
    public void updateAmountPullRequests(int amountPullRequests) {

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
