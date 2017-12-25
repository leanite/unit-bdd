package org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest;

import com.google.gson.annotations.SerializedName;

import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;

/**
 * Created by leandro on 24/12/2017.
 */

public interface GetAmountPullRequestsOutput {
    void onGetGetAmountPullRequestsSuccess(int amountPullRequests, PullRequest.State state);
    void onGetGetAmountPullRequestsError(ErrorData errorData);

    class ResponseData{

        @SerializedName("total_count")
        private int amountPullRequests;
        private PullRequest.State state;

        public int getAmountPullRequests() {
            return amountPullRequests;
        }

        public void setAmountPullRequests(int amountPullRequests) {
            this.amountPullRequests = amountPullRequests;
        }

        public PullRequest.State getState() {
            return state;
        }

        public void setState(PullRequest.State state) {
            this.state = state;
        }
    }

    class ErrorData{

    }
}

