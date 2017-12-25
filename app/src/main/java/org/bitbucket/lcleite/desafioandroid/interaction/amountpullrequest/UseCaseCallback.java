package org.bitbucket.lcleite.desafioandroid.interaction.amountpullrequest;

/**
 * Created by leandro on 25/12/2017.
 */

public interface UseCaseCallback<R,E> {
    void onSuccess(R responseData);
    void onError(E errorData);
}
