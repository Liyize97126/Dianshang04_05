package com.bawei.dianshang04_05;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.dianshang04_05.base.BaseActivity;
import com.bawei.dianshang04_05.bean.DataObjectBean;
import com.bawei.dianshang04_05.bean.GoodsBean;
import com.bawei.dianshang04_05.presenter.GoodsPresenter;
import com.bawei.dianshang04_05.util.DataCall;
import com.bumptech.glide.Glide;

import java.util.Random;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity implements DataCall<GoodsBean> {
    //定义
    private ImageView goods_thumb;
    private TextView goods_name,currency_price;
    private GoodsPresenter goodsPresenter;
    //方法实现
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void initView(Bundle savedInstanceState) {
        //初始化
        goods_thumb = findViewById(R.id.goods_thumb);
        goods_name = findViewById(R.id.goods_name);
        currency_price = findViewById(R.id.currency_price);
        goodsPresenter = new GoodsPresenter(this);
        //发起请求
        goodsPresenter.request();
    }
    @Override
    public void success(DataObjectBean<GoodsBean> data) {
        //随机数
        int i = new Random().nextInt(3);
        //设置显示内容
        goods_name.setText(data.getData().get(i).getGoods_name());
        currency_price.setText(data.getData().get(i).getCurrency_price());
        //Glide加载图片
        Glide.with(MainActivity.this).load(data.getData().get(i).getGoods_thumb()).into(goods_thumb);
        Toast.makeText(MainActivity.this,"当前展示的条目：" + (i + 1),Toast.LENGTH_LONG).show();
    }
    @Override
    public void fail(String error) {
        Toast.makeText(MainActivity.this,error,Toast.LENGTH_LONG).show();
    }
}
