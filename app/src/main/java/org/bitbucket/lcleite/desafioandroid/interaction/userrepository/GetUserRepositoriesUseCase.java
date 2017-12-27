package org.bitbucket.lcleite.desafioandroid.interaction.userrepository;

import org.bitbucket.lcleite.desafioandroid.entity.Repository;
import org.bitbucket.lcleite.desafioandroid.interaction.UseCaseCallback;

import java.util.List;

/**
 * Created by leandro on 26/12/2017.
 */

public interface GetUserRepositoriesUseCase extends
        GetUserRepositoriesInput,
        UseCaseCallback<List<Repository>, GetUserRepositoriesOutput.ErrorData> {
}
