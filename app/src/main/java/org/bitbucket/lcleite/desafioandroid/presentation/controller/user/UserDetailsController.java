package org.bitbucket.lcleite.desafioandroid.presentation.controller.user;

import org.bitbucket.lcleite.desafioandroid.interaction.userdata.GetUserDataInput;
import org.bitbucket.lcleite.desafioandroid.interaction.userdata.GetUserDataUseCase;
import org.bitbucket.lcleite.desafioandroid.interaction.userrepository.GetUserRepositoriesInput;
import org.bitbucket.lcleite.desafioandroid.interaction.userrepository.GetUserRepositoriesUseCase;

/**
 * Created by leandro on 26/12/2017.
 */

public class UserDetailsController {

    private GetUserDataUseCase getUserDataUseCase;
    private GetUserRepositoriesUseCase getUserRepositoriesUseCase;

    public UserDetailsController(GetUserDataUseCase getUserDataUseCase, GetUserRepositoriesUseCase getUserRepositoriesUseCase) {
        this.getUserDataUseCase = getUserDataUseCase;
        this.getUserRepositoriesUseCase = getUserRepositoriesUseCase;
    }

    public void getUserDetails(String username){
        GetUserDataInput.RequestData requestData = new GetUserDataInput.RequestData();
        requestData.setUsername(username);

        getUserDataUseCase.getUserDetails(requestData);
    }

    public void getUserRepositories(String username, int pageNumber){
        GetUserRepositoriesInput.RequestData requestData = new GetUserRepositoriesInput.RequestData();

        requestData.setUsername(username);
        requestData.setPageNumber(pageNumber);

        getUserRepositoriesUseCase.getUserRepositories(requestData);
    }
}
