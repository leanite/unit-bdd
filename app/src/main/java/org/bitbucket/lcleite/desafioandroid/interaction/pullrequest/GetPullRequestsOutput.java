package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;

import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public interface GetPullRequestsOutput {
    void onGetPullRequestsSuccess(List<PullRequest> pullRequests);
    void onGetPullRequestsError(ErrorData errorData);

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
