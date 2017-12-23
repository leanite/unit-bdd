package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;

import org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest.PullRequestDataSource;
import org.bitbucket.lcleite.desafioandroid.data.mapper.PullRequestDataModelMapper;
import org.bitbucket.lcleite.desafioandroid.data.model.PullRequestDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by leandro on 22/12/2017.
 */

public class GetPullRequestsUseCaseSpy implements GetPullRequestsUseCase, Callback<List<PullRequestDataModel>> {

    private PullRequestDataSource pullRequestDataSource;
    private GetPullRequestsOutput pullRequestListPresenter;
    private PullRequestDataModelMapper pullRequestDataMapper;

    public GetPullRequestsUseCaseSpy(PullRequestDataSource pullRequestDataSource, GetPullRequestsOutput pullRequestListPresenter) {
        this.pullRequestDataSource = pullRequestDataSource;
        this.pullRequestListPresenter = pullRequestListPresenter;
        this.pullRequestDataMapper = new PullRequestDataModelMapper();
    }

    @Override
    public void getPullRequests(RequestData requestData) {
        Repository repository = requestData.getRepository();
        String state = requestData.getState();
        int pageNumber = requestData.getPageNumber();

        pullRequestDataSource.getPullRequests(repository, state, pageNumber, this);
    }

    @Override
    public void onResponse(Call<List<PullRequestDataModel>> call, Response<List<PullRequestDataModel>> response) {
        List<PullRequestDataModel> pullRequestsData = response.body();
        List<PullRequest> pullRequests = pullRequestDataMapper.toEntityList(pullRequestsData);

        pullRequestListPresenter.onGetPullRequestsSuccess(pullRequests);
    }

    @Override
    public void onFailure(Call<List<PullRequestDataModel>> call, Throwable t) {

    }
}
