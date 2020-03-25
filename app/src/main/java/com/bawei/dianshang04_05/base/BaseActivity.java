package com.bawei.dianshang04_05.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 页面基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    //重写创建方法
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView(savedInstanceState);
    }
    //方法封装
    protected abstract int getLayoutId();
    protected abstract void initView(Bundle savedInstanceState);
}
