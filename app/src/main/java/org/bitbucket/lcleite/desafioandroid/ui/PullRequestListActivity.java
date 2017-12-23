package org.bitbucket.lcleite.desafioandroid.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.bitbucket.lcleite.desafioandroid.R;
import org.bitbucket.lcleite.desafioandroid.ui.fragment.PullRequestListFragment;

@EActivity(R.layout.activity_pullrequestlist)
public class PullRequestListActivity extends AppCompatActivity {

    @ViewById(R.id.tabViewPager)
    protected ViewPager tabViewPager;

    @ViewById(R.id.tabBar)
    protected TabLayout tabBar;

    private TabPagerAdapter tabPagerAdapter;

    @AfterViews
    protected void setupTabBar(){
        tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());

        tabViewPager.setAdapter(tabPagerAdapter);
        tabViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabBar));

        tabBar.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(tabViewPager));
    }

    public class TabPagerAdapter extends FragmentPagerAdapter {

        public TabPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return PullRequestListFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
