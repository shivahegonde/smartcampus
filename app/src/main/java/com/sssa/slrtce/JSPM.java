package com.sssa.slrtce;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.androidnetworking.AndroidNetworking;


/**
 * Created by Shiv on 2/20/2017.
 */

public class JSPM extends MultiDexApplication {

    private static JSPM istance;

    @Override
    public void onCreate() {
        super.onCreate();
        istance = this;
        AndroidNetworking.initialize(this);
        MultiDex.install(this);
    }

    /**
     * Instance of this class
     * @return
     */
    public static JSPM getIstance() {
        return istance;
    }

}

