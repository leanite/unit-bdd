package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;


import org.bitbucket.lcleite.desafioandroid.data.model.PullRequestDataModel;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by leandro on 22/12/2017.
 */

public interface GetPullRequestsUseCase extends
        GetPullRequestsInput, Callback<List<PullRequestDataModel>> {
}
