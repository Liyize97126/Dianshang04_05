package com.bawei.dianshang04_05.util;

import android.app.Application;
import android.content.Context;

/**
 * MyApplication类
 * 用于提供一个全局的静态的Context对象
 */
public class MyApplication extends Application {
    //定义
    private static Context context;
    //封装
    public static Context getContext() {
        return context;
    }
    //Application创建
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
