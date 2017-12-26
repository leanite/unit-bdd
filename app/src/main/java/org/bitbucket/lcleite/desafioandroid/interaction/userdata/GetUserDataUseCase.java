package org.bitbucket.lcleite.desafioandroid.interaction.userdata;

import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.interaction.UseCaseCallback;

/**
 * Created by leandro on 26/12/2017.
 */

public interface GetUserDataUseCase extends
        GetUserDataInput,
        UseCaseCallback<User, GetUserDataOutput.ErrorData> {
}
