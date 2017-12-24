package org.bitbucket.lcleite.desafioandroid.interaction.repository;

import retrofit2.Callback;

/**
 * Created by leandro on 22/12/2017.
 */

public interface GetRepositoriesUseCase extends
        GetRepositoriesInput, Callback<GetRepositoriesOutput.ResponseData> {
}
