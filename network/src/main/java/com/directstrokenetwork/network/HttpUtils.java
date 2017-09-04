package com.directstrokenetwork.network;

import android.content.Context;

import com.android.volley.Response;

import java.util.Map;

/**
 * Created by mbp on 31/08/2017.
 */

public class HttpUtils {

    public static <T> void sendGetGsonRequest(String url, Context context, Class<T> clazz, Map<String, String> headers, Response.Listener listener, Response.ErrorListener errorListener) {
        VolleySingleton.getInstance(context).addToRequestQueue(new GsonRequest(url, clazz, headers, listener, errorListener));
    }

    public static <T, E> void sendPostGsonRequest(String url, Context context, Class<T> clazz, Map<String, String> headers, E params, Response.Listener listener, Response.ErrorListener errorListener) {
        VolleySingleton.getInstance(context).addToRequestQueue(new GsonRequest(url, clazz, headers, params, listener, errorListener));
    }

}
