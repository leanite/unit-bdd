package org.bitbucket.lcleite.desafioandroid.interaction.user;

import org.bitbucket.lcleite.desafioandroid.data.datasource.user.UserDataSource;
import org.bitbucket.lcleite.desafioandroid.data.mapper.UserDataModelMapper;
import org.bitbucket.lcleite.desafioandroid.data.model.UserDataModel;
import org.bitbucket.lcleite.desafioandroid.data.service.UserRetrofitService;
import org.bitbucket.lcleite.desafioandroid.entity.User;
import org.bitbucket.lcleite.desafioandroid.interaction.UseCaseCallback;
import org.bitbucket.lcleite.desafioandroid.interaction.userdata.GetUserDataOutput;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leandro on 26/12/2017.
 */

public class UserDataSourceSpy implements UserDataSource {

    private Retrofit retrofit;
    private UserRetrofitService service;
    private UserDataModelMapper userDataModelMapper;

    public UserDataSourceSpy() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new GetUserMockInterceptor())
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        service = retrofit.create(UserRetrofitService.class);
        userDataModelMapper = new UserDataModelMapper();
    }

    @Override
    public void getUserDetails(String username, UseCaseCallback<User, GetUserDataOutput.ErrorData> callback) {
        Call<UserDataModel> call = service.getUserDetails(username);

        try {
            Response<UserDataModel> response = call.execute();
            UserDataModel userData = response.body();
            User user = userDataModelMapper.toEntity(userData);

            callback.onSuccess(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
