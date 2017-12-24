package org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest;

import retrofit2.Callback;

/**
 * Created by leandro on 24/12/2017.
 */

public interface GetAmountPullRequestsUseCase extends
        GetAmountPullRequestsInput, Callback<GetAmountPullRequestsOutput.ResponseData> {
}
