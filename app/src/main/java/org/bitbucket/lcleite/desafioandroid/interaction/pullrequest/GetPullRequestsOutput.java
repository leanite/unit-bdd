package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;

import com.google.gson.annotations.SerializedName;

import org.bitbucket.lcleite.desafioandroid.data.model.PullRequestDataModel;
import org.bitbucket.lcleite.desafioandroid.entity.PullRequest;

import java.util.List;

/**
 * Created by leandro on 22/12/2017.
 */

public interface GetPullRequestsOutput {
    void onGetPullRequestsSuccess(List<PullRequest> pullRequests);
    void onGetPullRequestsError(ErrorData errorData);

    class ResponseData{
        private List<PullRequestDataModel> pullRequests;

        public List<PullRequestDataModel> getPullRequests() {
            return pullRequests;
        }

        public void setPullRequests(List<PullRequestDataModel> pullRequests) {
            this.pullRequests = pullRequests;
        }
    }

    class ErrorData{

    }
}
