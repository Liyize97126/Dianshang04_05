package com.bawei.dianshang04_05.util;

import android.app.Application;
import android.content.Context;

/**
 * Context获取
 */
public class MyApplication extends Application {
    private static Context context;
    public static Context getContext() {
        return context;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
