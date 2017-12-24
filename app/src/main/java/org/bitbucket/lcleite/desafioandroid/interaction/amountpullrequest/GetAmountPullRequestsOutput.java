package org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by leandro on 24/12/2017.
 */

public interface GetAmountPullRequestsOutput {
    void onGetGetAmountPullRequestssSuccess(int amountPullRequests);
    void onGetGetAmountPullRequestsError(ErrorData errorData);

    class ResponseData{

        @SerializedName("total_count")
        private int amountPullRequests;

        public int getAmountPullRequests() {
            return amountPullRequests;
        }

        public void setAmountPullRequests(int amountPullRequests) {
            this.amountPullRequests = amountPullRequests;
        }
    }

    class ErrorData{

    }
}

