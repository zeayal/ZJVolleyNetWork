package com.directstrokenetwork.network.example;

import android.content.Context;
import com.android.volley.Response;
import com.directstrokenetwork.network.HttpUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mbp on 31/08/2017.
 */

public class EncapsulationHttpUtilsExample {

    public static <T> void sendGetGsonRequest(String url, Context context, Class<T> clazz, Response.Listener listener, Response.ErrorListener errorListener) {
        HttpUtils.sendGetGsonRequest(url, context, clazz, getHeaders(), listener, errorListener);
    }

    public static <T, E> void sendPostGsonRequest(String url, Context context, Class<T> clazz, E params, Response.Listener listener, Response.ErrorListener errorListener) {
        HttpUtils.sendPostGsonRequest(url, context, clazz, getHeaders(), params, listener, errorListener);
    }

    public static Map<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("key", "value");
        return headers;
    }

}
