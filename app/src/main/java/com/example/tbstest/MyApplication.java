package com.example.tbstest;

import android.app.Application;

import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by ring on 2019/5/6.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        QbSdk.initX5Environment(getApplicationContext(), null);
    }
}
