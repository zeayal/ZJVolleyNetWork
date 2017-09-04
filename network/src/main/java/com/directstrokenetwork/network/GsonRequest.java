package com.directstrokenetwork.network;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by mbp on 31/08/2017.
 */

public class GsonRequest<T, E> extends Request<T> {

    private final Gson gson = new Gson();
    private final Class<T> clazz;
    private final Map<String, String>headers;
    private E params;
    private final Response.Listener<T> listener;

    public GsonRequest(String url, Class<T> clazz, Map<String, String> headers, Response.Listener listener, Response.ErrorListener errorListener) {
        super(Method.GET ,url, errorListener);
        this.clazz = clazz;
        this.headers = headers;
        this.listener = listener;
    }

    public GsonRequest(int method, String url, Class<T> clazz, Map<String, String> headers, E params,Response.Listener listener, Response.ErrorListener errorListener) {
        super(method ,url, errorListener);
        this.clazz = clazz;
        this.headers = headers;
        this.listener = listener;
        this.params = params;
    }


    /**
     * POST 请求
     * @param url
     * @param clazz
     * @param headers
     * @param params
     * @param listener
     * @param errorListener
     */
    public  GsonRequest(String url, Class<T> clazz, Map<String, String> headers, E params, Response.Listener listener, Response.ErrorListener errorListener) {
        super(Method.POST ,url, errorListener);
        this.clazz = clazz;
        this.headers = headers;
        this.listener = listener;
        this.params = params;
        Log.d("TAG:Debug:params", params.toString());
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public byte[] getBody() throws AuthFailureError {
        byte[] bytes = new byte[0];
        try {
            bytes = ParamsTypeConversion.convertToByte(params);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Log.d("TAG:Debug:params", params.toString());
//        Log.d("TAG:Debug:params.byte", bytes.toString());
        return bytes != null ? bytes : super.getBody();
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {

        try {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            Log.d("Tag:debug:GsonRequest:", "parseNetworkResponse");
            return Response.success(
                    gson.fromJson(json, clazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
        return null;
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

}
