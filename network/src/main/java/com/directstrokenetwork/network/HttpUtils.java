package com.directstrokenetwork.network;

import android.content.Context;

import com.android.volley.Response;

/**
 * Created by mbp on 31/08/2017.
 */

public class HttpUtils {

    public static <T> void sendGetGsonRequest(String url, Context context, Class<T> clazz, Response.Listener listener, Response.ErrorListener errorListener) {
        VolleySingleton.getInstance(context).addToRequestQueue(new GsonRequest(url, clazz, null, listener, errorListener));
    }

}
