package org.bitbucket.lcleite.desafioandroid.interaction.userrepository;


/**
 * Created by leandro on 26/12/2017.
 */

public interface GetUserRepositoriesInput {

    void getUserRepositories(RequestData requestData);

    class RequestData {
        private String username;
        private int pageNumber;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }
    }
}
