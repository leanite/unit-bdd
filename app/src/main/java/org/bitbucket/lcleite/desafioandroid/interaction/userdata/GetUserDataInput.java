package org.bitbucket.lcleite.desafioandroid.interaction.userdata;


/**
 * Created by leandro on 26/12/2017.
 */

public interface GetUserDataInput {

    void getUserDetails(RequestData requestData);

    class RequestData {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
