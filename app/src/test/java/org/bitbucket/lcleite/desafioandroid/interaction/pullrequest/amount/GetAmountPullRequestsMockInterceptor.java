package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.amount;

import org.bitbucket.lcleite.desafioandroid.interaction.pullrequest.GetPullRequestsMockInterceptor;

/**
 * Created by leandro on 25/12/2017.
 */

public class GetAmountPullRequestsMockInterceptor extends GetPullRequestsMockInterceptor {

    @Override
    protected String getResponseMock() {
        return "{\n" +
                "  \"total_count\": 125,\n" +
                "  \"incomplete_results\": false,\n" +
                "  \"items\": []\n" +
                "}";
    }
}
