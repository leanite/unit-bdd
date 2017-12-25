package org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest;


import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;
import org.bitbucket.lcleite.desafioandroid.entity.Repository;

/**
 * Created by leandro on 24/12/2017.
 */

public interface GetAmountPullRequestsInput {

    void getAmountPullRequests(RequestData requestData);

    class RequestData {
        private Repository repository;
        private PullRequest.State state;

        public Repository getRepository() {
            return repository;
        }

        public void setRepository(Repository repository) {
            this.repository = repository;
        }

        public PullRequest.State getState() {
            return state;
        }

        public void setState(PullRequest.State state) {
            this.state = state;
        }
    }
}
