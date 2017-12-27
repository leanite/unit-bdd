package org.bitbucket.lcleite.desafioandroid.interaction.userdata;


import org.bitbucket.lcleite.desafioandroid.entity.User;


/**
 * Created by leandro on 26/12/2017.
 */

public interface GetUserDataOutput {
    void onGetUserDataSuccess(User user);
    void onGetUserDataError(ErrorData errorData);

    class ErrorData{
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
