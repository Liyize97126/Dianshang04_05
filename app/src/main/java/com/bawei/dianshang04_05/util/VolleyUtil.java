package com.bawei.dianshang04_05.util;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;

/**
 * 网络请求框架
 */
public class VolleyUtil {
    //创建队列
    private static RequestQueue queue = Volley.newRequestQueue(MyApplication.getContext());
    //请求方法
    public static void get(String httpUrl, final IModel iModel){
        //发起请求
        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("Tag", response);
                        iModel.requestSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Tag", error.getMessage());
                        iModel.requestError(error.getMessage());
                    }
                }){
            //解决Volley中文乱码问题可用下面这个方法（无需记忆，可以直接复制）
            protected Response<String> parseNetworkResponse(NetworkResponse response){
                try {
                    String string = new String(response.data, "UTF-8");
                    return Response.success(string,
                            HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (Exception je) {
                    return Response.error(new ParseError(je));
                }
            }
        };
        //将请求添加至队列
        queue.add(stringRequest);
    }
}
