package com.andy.popularmovies;

import android.app.Application;

import com.andy.popularmovies.injection.ApplicationComponent;
import com.andy.popularmovies.injection.DaggerApplicationComponent;
import com.andy.popularmovies.injection.NetModule;

/**
 * Created by andrewjoyce on 04/03/2017.
 */

public class PopularMoviesApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .netModule(new NetModule())
                    .build();
        }
        return mApplicationComponent;
    }

}
