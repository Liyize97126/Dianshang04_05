package com.bawei.dianshang04_05.util;

/**
 * IModel接口，用于向Presenter传递数据
 */
public interface IModel {
    void requestSuccess(String response);
    void requestError(String error);
}
