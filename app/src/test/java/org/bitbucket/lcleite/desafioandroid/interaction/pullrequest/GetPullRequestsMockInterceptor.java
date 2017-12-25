package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * Created by leandro on 22/12/2017.
 */


public abstract class GetPullRequestsMockInterceptor implements Interceptor {

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

    abstract protected String getResponseMock();
}
