package com.bawei.dianshang04_05.util;

import com.bawei.dianshang04_05.bean.DataObjectBean;

/**
 * 处理界面返回数据接口
 */
public interface DataCall<T> {
    void success(DataObjectBean<T> data);
    void fail(String error);
}
