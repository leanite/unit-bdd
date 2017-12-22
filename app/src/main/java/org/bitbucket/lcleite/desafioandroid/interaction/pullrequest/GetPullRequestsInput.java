package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;


/**
 * Created by leandro on 22/12/2017.
 */

public interface GetPullRequestsInput {

    void getPullRequests(RequestData requestData);

    class RequestData {
        private String username;
        private String repositoryName;
        private String state;
        private int pageNumber;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getRepositoryName() {
            return repositoryName;
        }

        public void setRepositoryName(String repositoryName) {
            this.repositoryName = repositoryName;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }
    }
}
