package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;


import org.bitbucket.lcleite.desafioandroid.entity.Repository;

/**
 * Created by leandro on 22/12/2017.
 */

public interface GetPullRequestsInput {

    void getPullRequests(RequestData requestData);

    class RequestData {
        private Repository repository;
        private String state;
        private int pageNumber;

        public Repository getRepository() {
            return repository;
        }

        public void setRepository(Repository repository) {
            this.repository = repository;
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
