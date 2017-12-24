package org.bitbucket.lcleite.desafioandroid.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.bitbucket.lcleite.desafioandroid.R;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest.PullRequestListController;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestListPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.view.PullRequestListView;
import org.bitbucket.lcleite.desafioandroid.presentation.viewmodel.PullRequestListViewModel;
import org.bitbucket.lcleite.desafioandroid.ui.adapter.PullRequestListAdapter;
import org.bitbucket.lcleite.desafioandroid.ui.app.App;
import org.bitbucket.lcleite.desafioandroid.ui.divider.ListDivider;
import org.bitbucket.lcleite.desafioandroid.ui.scroll.EndlessScrollListener;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

public class PullRequestListFragment extends Fragment implements PullRequestListView {
    /*
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    */

    protected SwipeRefreshLayout swipeRefresh;
    protected RecyclerView pullRequestsRecyclerView;

    @Inject PullRequestListController pullRequestListController; //FIXME: private
    @Inject PullRequestListPresenter pullRequestListPresenter;
    @Inject PullRequestListViewModel pullRequestListViewModel;

    PullRequestListAdapter pullRequestsAdapter;
    EndlessScrollListener endlessScrollListener;

    public PullRequestListFragment() {
        // Required empty public constructor
    }

    protected void setup(){
        setupViews();
        onSetupDone();
    }

    private void setupViews(){
        setupRefreshContainer();
        setupPullRequestRecyclerViewAdapter();
        setupPullRequestsRecyclerView();
    }

    private void setupRefreshContainer() {
        swipeRefresh.setOnRefreshListener(this);
        swipeRefresh.setColorSchemeColors(
                ContextCompat.getColor(getContext(), R.color.colorPrimary),
                ContextCompat.getColor(getContext(), R.color.colorAccent)
        );
    }

    private void setupPullRequestRecyclerViewAdapter(){
        pullRequestsAdapter = new PullRequestListAdapter(pullRequestListViewModel.getPullRequests());
        pullRequestsAdapter.setOnItemClickListener(this);
    }

    private void setupPullRequestsRecyclerView() {
        endlessScrollListener = new EndlessScrollListener(this);
        pullRequestsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        pullRequestsRecyclerView.setAdapter(pullRequestsAdapter);
        pullRequestsRecyclerView.addItemDecoration(
                new ListDivider(ContextCompat.getDrawable(getContext(), R.drawable.divider_item_list)));
        pullRequestsRecyclerView.addOnScrollListener(endlessScrollListener);
    }

    private void setupPresenters(){
        pullRequestListPresenter.setView(this); //TODO: set again when tab changes
    }

    private void onSetupDone() { //TODO: implement on tab change on activity
//        getPullRequests();
    }

    @Override
    public void onRefresh() {
        pullRequestListViewModel.resetPage();
        pullRequestListViewModel.clearPullRequests();
        endlessScrollListener.reset();
        getPullRequests();
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void endlessLoadMoreItems() {
        pullRequestListViewModel.incrementPage();
        getPullRequests();
    }

    @Override
    public void updatePullRequests(List<PullRequest> pullRequests) {
        pullRequestListViewModel.appendPullRequests(pullRequests);
    }

    @Override
    public void updateUiAfterQuery() {
        swipeRefresh.setRefreshing(false);
        pullRequestsAdapter.notifyDataSetChanged();
    }

    private void getPullRequests(){
        setupPresenters();
        swipeRefresh.setRefreshing(true);
        Repository repository = createMockRepository();
        pullRequestListController.getPullRequests(repository, "closed", pullRequestListViewModel.getCurrentPage());
    }

    private Repository createMockRepository() {
        Repository repository = new Repository();
        User owner = new User();

        owner.setUsername("elastic");
        repository.setOwner(owner);
        repository.setName("elasticsearch");

        return repository;
    }

    public static PullRequestListFragment newInstance() {
        PullRequestListFragment fragment = new PullRequestListFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((App) getContext().getApplicationContext()).getPullRequestListComponent().inject(this);

        View view = inflater.inflate(R.layout.fragment_pullrequestlist, container, false);

        swipeRefresh = view.findViewById(R.id.refreshContainer);
        pullRequestsRecyclerView = view.findViewById(R.id.rvPullRequestList);

        setup();

        return view;
    }
}
