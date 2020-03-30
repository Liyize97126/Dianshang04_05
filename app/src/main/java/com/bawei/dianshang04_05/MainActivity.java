package com.bawei.dianshang04_05;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.dianshang04_05.adapter.MyBaseAdapter;
import com.bawei.dianshang04_05.base.BaseActivity;
import com.bawei.dianshang04_05.bean.DataObjectBean;
import com.bawei.dianshang04_05.bean.GoodsBean;
import com.bawei.dianshang04_05.presenter.GoodsPresenter;
import com.bawei.dianshang04_05.util.DataCall;

import java.util.Random;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity implements DataCall<GoodsBean> {
    //定义
    private ListView listv;
    private GoodsPresenter goodsPresenter;
    private MyBaseAdapter myBaseAdapter;
    private int i;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void initView(Bundle savedInstanceState) {
        listv = findViewById(R.id.listv);
        //随机数
        i = new Random().nextInt(3);
        //设置适配器
        myBaseAdapter = new MyBaseAdapter();
        listv.setAdapter(myBaseAdapter);
        goodsPresenter = new GoodsPresenter(this);
        //发起请求
        goodsPresenter.request(i);
    }
    @Override
    public void success(DataObjectBean<GoodsBean> data) {
        myBaseAdapter.getList().addAll(data.getData());
        myBaseAdapter.notifyDataSetChanged();
        //提示
        Toast.makeText(MainActivity.this,"当前展示的条目：" + (i + 1),Toast.LENGTH_LONG).show();
    }
    @Override
    public void fail(String error) {
        Toast.makeText(MainActivity.this,"参数错误！\n错误信息：" + error,Toast.LENGTH_LONG).show();
    }
}
