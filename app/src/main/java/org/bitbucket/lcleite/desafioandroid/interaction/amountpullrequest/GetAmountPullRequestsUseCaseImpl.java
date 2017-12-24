package org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest;

import android.util.Log;

import org.bitbucket.lcleite.desafioandroid.data.datasource.pullrequest.PullRequestDataSource;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by leandro on 24/12/2017.
 */

public class GetAmountPullRequestsUseCaseImpl implements GetAmountPullRequestsUseCase {

    private PullRequestDataSource pullRequestDataSource;
    private GetAmountPullRequestsOutput amountPullRequestListPresenter;

    public GetAmountPullRequestsUseCaseImpl(PullRequestDataSource pullRequestDataSource, GetAmountPullRequestsOutput amountPullRequestListPresenter) {
        this.pullRequestDataSource = pullRequestDataSource;
        this.amountPullRequestListPresenter = amountPullRequestListPresenter;
    }

    @Override
    public void getAmountPullRequests(RequestData requestData) {
        Repository repository = requestData.getRepository();
        String state = requestData.getState();

        pullRequestDataSource.getAmountPullRequests(repository, state, this);
    }

    @Override
    public void onResponse(Call<GetAmountPullRequestsOutput.ResponseData> call, Response<GetAmountPullRequestsOutput.ResponseData> response) {
        int amountPullRequests = response.body().getAmountPullRequests();

        Log.d("OK", amountPullRequests+"");
        amountPullRequestListPresenter.onGetGetAmountPullRequestssSuccess(amountPullRequests);
    }

    @Override
    public void onFailure(Call<GetAmountPullRequestsOutput.ResponseData> call, Throwable t) {

    }
}
