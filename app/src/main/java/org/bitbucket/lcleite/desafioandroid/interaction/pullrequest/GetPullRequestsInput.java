package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;


import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;

/**
 * Created by leandro on 22/12/2017.
 */

public interface GetPullRequestsInput {

    void getPullRequests(RequestData requestData);

    class RequestData {
        private String repositoryUsername;
        private String repositoryName;
        private PullRequest.State state;
        private int pageNumber;

        public String getRepositoryUsername() {
            return repositoryUsername;
        }

        public void setRepositoryUsername(String repositoryUsername) {
            this.repositoryUsername = repositoryUsername;
        }

        public String getRepositoryName() {
            return repositoryName;
        }

        public void setRepositoryName(String repositoryName) {
            this.repositoryName = repositoryName;
        }

        public PullRequest.State getState() {
            return state;
        }

        public void setState(PullRequest.State state) {
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
