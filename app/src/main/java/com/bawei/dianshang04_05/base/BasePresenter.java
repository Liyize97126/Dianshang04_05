package com.bawei.dianshang04_05.base;

import com.bawei.dianshang04_05.bean.DataObjectBean;
import com.bawei.dianshang04_05.util.DataCall;
import com.bawei.dianshang04_05.util.IModel;
import com.bawei.dianshang04_05.util.VolleyUtil;
import com.google.gson.Gson;

/**
 * BasePresenter请求处理基类
 */
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
    //定义发送请求方法，所有页面请求都需要调用它
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
    //由于每个Presenter请求链接不一样，所以需要抽象方法；类似于BaseActivity中的getLayoutId()
    protected abstract String getUrl(Object...args);
    //由于每个Presenter的响应结果不一样，所以需要对应不同的解析过程
    protected abstract DataObjectBean getData(String response);
}
