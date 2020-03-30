package com.bawei.dianshang04_05.bean;

import java.io.Serializable;
import java.util.List;

public class DataObjectBean<T> implements Serializable {
    private List<T> data;
    public List<T> getData() {
        return data;
    }
    public void setData(List<T> data) {
        this.data = data;
    }
}
