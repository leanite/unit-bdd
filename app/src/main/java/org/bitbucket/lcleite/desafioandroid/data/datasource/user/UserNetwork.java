package org.bitbucket.lcleite.desafioandroid.data.datasource.user;

import org.bitbucket.lcleite.desafioandroid.data.mapper.UserDataModelMapper;
import org.bitbucket.lcleite.desafioandroid.data.model.UserDataModel;
import org.bitbucket.lcleite.desafioandroid.data.service.UserRetrofitService;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.interaction.UseCaseCallback;
import org.bitbucket.lcleite.desafioandroid.interaction.userdata.GetUserDataOutput;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by leandro on 26/12/2017.
 */

public class UserNetwork implements UserDataSource{

    private UserRetrofitService service;
    private UserDataModelMapper userDataModelMapper;

    public UserNetwork(Retrofit retrofit) {
        service = retrofit.create(UserRetrofitService.class);
        userDataModelMapper = new UserDataModelMapper();
    }

    @Override
    public void getUserDetails(String username, final UseCaseCallback<User, GetUserDataOutput.ErrorData> callback) {
        Call<UserDataModel> call = service.getUserDetails(username);

        call.enqueue(new Callback<UserDataModel>() {
            @Override
            public void onResponse(Call<UserDataModel> call, Response<UserDataModel> response) {
                UserDataModel userData = response.body();
                User user = userDataModelMapper.toEntity(userData);

                callback.onSuccess(user);
            }

            @Override
            public void onFailure(Call<UserDataModel> call, Throwable t) {

            }
        });
    }
}
