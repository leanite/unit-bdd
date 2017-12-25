package org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest;

/**
 * Created by leandro on 24/12/2017.
 */

public interface GetAmountPullRequestsUseCase extends
        GetAmountPullRequestsInput,
        UseCaseCallback<GetAmountPullRequestsOutput.ResponseData, GetAmountPullRequestsOutput.ErrorData> {
}
