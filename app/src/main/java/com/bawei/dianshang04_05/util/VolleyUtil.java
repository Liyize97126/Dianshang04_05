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
 * VolleyUtil网络框架
 */
public class VolleyUtil {
    //定义Volley请求队列，http请求需要放入Volley队列进行发送
    private static RequestQueue queue = Volley.newRequestQueue(MyApplication.getContext());
    //定义get请求方法
    public static void get(String httpUrl, final IModel iModel){
        /*StringRequest封装了http请求
        第一个参数是http请求方式：get,post,delete,put
        第二个参数是url请求链接
        第三个参数是响应结果回调
        第四个参数是请求错误异常回调*/
        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //此处写请求成功回调
                        Log.i("Tag",response);
                        iModel.requestSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //此处写请求失败回调
                        Log.e("Tag",error.getMessage());
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
        //最后一步：通过队列发送请求。
        //其中已经进行了子线程和主线程的通信，所以我们后续无需关心线程切换问题。
        queue.add(stringRequest);
    }
}
