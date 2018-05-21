package com.gradle;

import android.app.Application;
import android.content.Context;

/**
 * Created by gaolei on 2018/4/16.
 */

public class MyApplication extends Application {

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
//        Mlutidex.install(this);
    }
}
