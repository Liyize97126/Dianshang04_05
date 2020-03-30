package com.bawei.dianshang04_05.base;

import com.bawei.dianshang04_05.bean.DataObjectBean;
import com.bawei.dianshang04_05.util.DataCall;
import com.bawei.dianshang04_05.util.IModel;
import com.bawei.dianshang04_05.util.VolleyUtil;
import com.google.gson.Gson;

public abstract class BasePresenter {
    //定义
    private static final Gson GSON = new Gson();
    private DataCall dataCall;
    //处理
    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }
    public static Gson getGSON() {
        return GSON;
    }
    //请求方法
    public void request(Object...args){
        //调用请求方法
        VolleyUtil.get(getUrl(args), new IModel() {
            @Override
            public void requestSuccess(String response) {
                //解析方法
                DataObjectBean data = getData(response);
                dataCall.success(data);
            }
            @Override
            public void requestError(String error) {
                dataCall.fail(error);
            }
        });
    }
    //方法封装
    protected abstract String getUrl(Object...args);
    protected abstract DataObjectBean getData(String response);
}
