package org.bitbucket.lcleite.desafioandroid.interaction.repository;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.UseCaseCallback;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public interface GetRepositoriesUseCase extends
        GetRepositoriesInput,
        UseCaseCallback<List<Repository>, GetRepositoriesOutput.ErrorData> {
}
