package org.bitbucket.lcleite.desafioandroid.injection;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leandro on 23/12/2017.
 */

@Module
public class ApplicationModule {

    private Application aplication;

    public ApplicationModule(Application aplication) {
        this.aplication = aplication;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return aplication;
    }
}