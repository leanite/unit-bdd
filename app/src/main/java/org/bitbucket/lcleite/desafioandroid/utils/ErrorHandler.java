package org.bitbucket.lcleite.desafioandroid.utils;

import java.net.UnknownHostException;

/**
 * Created by leandro on 27/12/2017.
 */

public class ErrorHandler {
    public static String getErrorMessage(Throwable throwable) {
        if(UnknownHostException.class.isInstance(throwable))
            return "Network error: unable to resolve host.";

        return "Error: please try again later.";
    }
}
