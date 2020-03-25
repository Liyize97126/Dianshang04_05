package com.bawei.dianshang04_05.presenter;

import com.bawei.dianshang04_05.base.BasePresenter;
import com.bawei.dianshang04_05.bean.DataObjectBean;
import com.bawei.dianshang04_05.bean.GoodsBean;
import com.bawei.dianshang04_05.util.DataCall;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * 请求处理
 */
public class GoodsPresenter extends BasePresenter {
    //构造
    public GoodsPresenter(DataCall dataCall) {
        super(dataCall);
    }
    //方法实现
    @Override
    protected String getUrl(Object... args) {
        return "http://blog.zhaoliang5156.cn/api/shop/shop1.json";
    }
    @Override
    protected DataObjectBean getData(String response) {
        //泛型处理
        Type type = new TypeToken<DataObjectBean<GoodsBean>>() {
        }.getType();
        return getGSON().fromJson(response,type);
    }
}
