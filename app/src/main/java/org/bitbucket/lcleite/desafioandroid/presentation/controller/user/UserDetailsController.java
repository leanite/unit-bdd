package org.bitbucket.lcleite.desafioandroid.presentation.controller.user;

import org.bitbucket.lcleite.desafioandroid.interaction.userdata.GetUserDataInput;
import org.bitbucket.lcleite.desafioandroid.interaction.userdata.GetUserDataUseCase;

/**
 * Created by leandro on 26/12/2017.
 */

public class UserDetailsController {

    private GetUserDataUseCase getUserDataUseCase;

    public UserDetailsController(GetUserDataUseCase getUserDataUseCase) {
        this.getUserDataUseCase = getUserDataUseCase;
    }

    public void getUserDetails(String username){
        GetUserDataInput.RequestData requestData = new GetUserDataInput.RequestData();
        requestData.setUsername(username);

        getUserDataUseCase.getUserDetails(requestData);
    }
}
