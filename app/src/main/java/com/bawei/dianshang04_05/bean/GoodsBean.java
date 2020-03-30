package com.bawei.dianshang04_05.bean;

import java.io.Serializable;

public class GoodsBean implements Serializable {
    private String currency_price;
    private String goods_name;
    private String goods_thumb;
    public String getCurrency_price() {
        return currency_price;
    }
    public void setCurrency_price(String currency_price) {
        this.currency_price = currency_price;
    }
    public String getGoods_name() {
        return goods_name;
    }
    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }
    public String getGoods_thumb() {
        return goods_thumb;
    }
    public void setGoods_thumb(String goods_thumb) {
        this.goods_thumb = goods_thumb;
    }
}
