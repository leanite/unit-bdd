package org.bitbucket.lcleite.desafioandroid.interaction.user;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * Created by leandro on 26/12/2017.
 */


public class GetUserMockInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        String responseString = getResponseMock();
        Response response = new Response.Builder()
            .code(200)
            .message(responseString)
            .request(chain.request())
            .protocol(Protocol.HTTP_1_0)
            .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
            .addHeader("content-type", "application/json")
            .build();

        return response;
    }

    private String getResponseMock(){
        return "{\n" +
                "  \"login\": \"elastic\",\n" +
                "  \"id\": 6764390,\n" +
                "  \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "  \"gravatar_id\": \"\",\n" +
                "  \"url\": \"https://api.github.com/users/elastic\",\n" +
                "  \"html_url\": \"https://github.com/elastic\",\n" +
                "  \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "  \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "  \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "  \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "  \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "  \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "  \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "  \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "  \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "  \"type\": \"Organization\",\n" +
                "  \"site_admin\": false,\n" +
                "  \"name\": \"elastic\",\n" +
                "  \"company\": null,\n" +
                "  \"blog\": \"https://www.elastic.co/\",\n" +
                "  \"location\": null,\n" +
                "  \"email\": null,\n" +
                "  \"hireable\": null,\n" +
                "  \"bio\": null,\n" +
                "  \"public_repos\": 190,\n" +
                "  \"public_gists\": 2,\n" +
                "  \"followers\": 0,\n" +
                "  \"following\": 0,\n" +
                "  \"created_at\": \"2014-02-23T17:48:57Z\",\n" +
                "  \"updated_at\": \"2017-08-25T09:44:30Z\"\n" +
                "}";
    }
}
