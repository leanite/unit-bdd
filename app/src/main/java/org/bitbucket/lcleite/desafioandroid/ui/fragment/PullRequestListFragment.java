package org.bitbucket.lcleite.desafioandroid.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.bitbucket.lcleite.desafioandroid.R;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.presentation.controller.pullrequest.PullRequestListController;
import org.bitbucket.lcleite.desafioandroid.presentation.presenter.pullrequest.PullRequestListPresenter;
import org.bitbucket.lcleite.desafioandroid.presentation.view.PullRequestListView;
import org.bitbucket.lcleite.desafioandroid.presentation.viewmodel.PullRequestListViewModel;
import org.bitbucket.lcleite.desafioandroid.ui.PullRequestListActivity;
import org.bitbucket.lcleite.desafioandroid.ui.adapter.PullRequestListAdapter;
import org.bitbucket.lcleite.desafioandroid.ui.divider.ListDivider;
import org.bitbucket.lcleite.desafioandroid.ui.scroll.EndlessScrollListener;

import java.util.List;

public abstract class PullRequestListFragment extends Fragment implements PullRequestListView {
    protected PullRequestListController pullRequestListController;
    protected PullRequestListPresenter pullRequestListPresenter;
    protected PullRequestListViewModel pullRequestListViewModel;

    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView pullRequestsRecyclerView;

    private PullRequestListAdapter pullRequestsAdapter;
    private EndlessScrollListener endlessScrollListener;

    public PullRequestListFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupModels(getArguments());
    }

    private void setupModels(Bundle args) {
        pullRequestListViewModel = new PullRequestListViewModel();

        if (args != null)
            setupRepositoryInfo(args);
    }

    private void setupRepositoryInfo(Bundle args){
        String repositoryUsername = args.getString(PullRequestListActivity.REPOSITORY_USERNAME);
        String repositoryName = args.getString(PullRequestListActivity.REPOSITORY_NAME);

        pullRequestListViewModel.setRepositoryInfo(repositoryUsername, repositoryName);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pullrequestlist, container, false);

        setupViews(view);
        onSetupDone();

        return view;
    }

    private void setupViews(View view){
        initViews(view);
        setupRefreshContainer();
        setupPullRequestRecyclerViewAdapter();
        setupPullRequestsRecyclerView();
    }

    private void initViews(View view){
        swipeRefresh = view.findViewById(R.id.refreshContainer);
        pullRequestsRecyclerView = view.findViewById(R.id.rvPullRequestList);
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

    private void onSetupDone() {
        getPullRequests();
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
        PullRequest pullRequest = pullRequestListViewModel.getPullRequestAt(position);

        pullRequestListPresenter.goToPullRequestUrl(pullRequest.getUrl(), getActivity());
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
        String repositoryUsername = pullRequestListViewModel.getRepositoryUsername();
        String repositoryName = pullRequestListViewModel.getRepositoryName();

        swipeRefresh.setRefreshing(true);
        pullRequestListController.getPullRequests(repositoryUsername,repositoryName, getPullRequestState(), pullRequestListViewModel.getCurrentPage());
    }

    abstract PullRequest.State getPullRequestState();

    abstract void setController(PullRequestListController controller);

    abstract void setPresenter(PullRequestListPresenter presenter);
}
