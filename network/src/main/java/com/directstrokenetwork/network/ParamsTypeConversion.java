package com.directstrokenetwork.network;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by mbp on 31/08/2017.
 */

public class ParamsTypeConversion {

    /***
     * 转换 Object | JsonObject
     * @param params
     * @param <T>
     * @return byte[] | null
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static <T> byte[] convertToByte(T params) throws IOException {

        if (params != null) {
            if (params instanceof JSONObject || params instanceof JSONArray) {
                Log.d("TAG:Debug:ParamsTypeConversion:JSONObject to byte[]", String.valueOf(params.toString()));
                return params.toString().getBytes();
            } else if (params instanceof Object) {
                // 转换对象到 byte[]
                byte[] bytes = serialize(params);
                Log.d("TAG:Debug:ParamsTypeConversion:转换对象到 byte[]", bytes.toString());
                return serialize(bytes);

            }
        }
        return null;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static byte[] serialize(Object obj) throws IOException {
        try(ByteArrayOutputStream b = new ByteArrayOutputStream()){
            try(ObjectOutputStream o = new ObjectOutputStream(b)){
                o.writeObject(obj);
            }
            return b.toByteArray();
        }
    }
}
