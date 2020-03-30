package com.bawei.dianshang04_05.util;

import com.bawei.dianshang04_05.bean.DataObjectBean;

/**
 * 反馈接口
 */
public interface DataCall<T> {
    void success(DataObjectBean<T> data);
    void fail(String error);
}
