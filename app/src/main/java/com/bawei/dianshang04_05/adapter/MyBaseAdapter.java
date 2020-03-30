package com.bawei.dianshang04_05.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dianshang04_05.R;
import com.bawei.dianshang04_05.bean.GoodsBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器
 */
public class MyBaseAdapter extends BaseAdapter {
    //定义
    private List<GoodsBean> list = new ArrayList<>();
    public List<GoodsBean> getList() {
        return list;
    }
    //方法实现
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    //视图展示
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHouler myViewHouler;
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listcontent, parent, false);
            myViewHouler = new MyViewHouler();
            myViewHouler.goods_thumb = convertView.findViewById(R.id.goods_thumb);
            myViewHouler.goods_name = convertView.findViewById(R.id.goods_name);
            myViewHouler.currency_price = convertView.findViewById(R.id.currency_price);
            convertView.setTag(myViewHouler);
        } else {
            myViewHouler = (MyViewHouler) convertView.getTag();
        }
        //设置数据
        GoodsBean goodsBean = list.get(position);
        //设置显示内容
        myViewHouler.goods_name.setText(goodsBean.getGoods_name());
        myViewHouler.currency_price.setText(goodsBean.getCurrency_price());
        //Glide加载图片
        Glide.with(myViewHouler.goods_thumb).load(goodsBean.getGoods_thumb()).into(myViewHouler.goods_thumb);
        return convertView;
    }
    //寄存器
    class MyViewHouler{
        ImageView goods_thumb;
        TextView goods_name,currency_price;
    }
}
