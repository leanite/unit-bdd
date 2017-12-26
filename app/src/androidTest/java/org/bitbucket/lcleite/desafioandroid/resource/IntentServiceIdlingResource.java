package org.bitbucket.lcleite.desafioandroid.resource;

import android.app.ActivityManager;
import android.content.Context;
import android.support.test.espresso.IdlingResource;

/**
 * Created by leandro on 26/12/2017.
 */

public class IntentServiceIdlingResource implements IdlingResource {
    private final Context context;
    private ResourceCallback resourceCallback;
    private String serviceClassName;

    public IntentServiceIdlingResource(Class serviceClass, Context context) {
        this.context = context;
        this.serviceClassName = serviceClass.getName();
    }

    @Override
    public String getName() {
        return IntentServiceIdlingResource.class.getName();
    }

    @Override
    public boolean isIdleNow() {
        boolean idle = !isIntentServiceRunning();
        if (idle && resourceCallback != null) {
            resourceCallback.onTransitionToIdle();
        }
        return idle;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }

    private boolean isIntentServiceRunning() {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo info : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClassName.equals(info.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
