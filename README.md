# ZJVolleyNetWork
> 目标：封装 `Volley` `GTE` & `POST` 请求
> 功能：
>> 可以自定义使用静态方法一句代码完成普通请求，有效减少胶水代码，隔离 `Volley` 库以增强项目的可维护性
>> 回调中直接返回 `Gson` 解析好的对象模型，不会返回 json 字符串

### 使用方法

#### 方法一：使用 AndroidStdio Gradle 构建：

** Step 1. 集成本三方库到项目依赖中

```
    // Add the repository to your build file
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

    // Add the dependency
    dependencies {
        compile 'com.github.zeayal:ZJVolleyNetWork:1.0.0'
    }

```

** 模拟接口 **

*这里模拟一个 Get && POST 接口：http://rapapi.org/mockjsdata/25158/api/orders(这个接口也可以 post)*
```
// 接口返回数据
 {
     "data": {
         "orderId": "测试内容8m34"
     },
     "message": "测试内容553l",
     "status": 33717
 }

// 根据接口返回数据，新建实体类，新建到你项目的模型目录即可。
public class Order {

    private Number status;
    private String message;
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        private String orderId;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    Order() {

    }

    public Number getStatus() {
        return status;
    }

    public void setStatus(Number status) {
        this.status = status;
    }


}




```

** 这里需要自己在封装一个工具类进行 header 的封装 **
```

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
        headers.put("key", "value"); // 这里设置 header
        return headers;
    }

}

```

** Step 3. 在工程总任意 Activity 中使用（记得先添加网络权限） **
```

    //发送 get StringRequest 请求
    private void sendGetRequest() {}

    //发送 post StringRequest 请求
    private void sendPostRequest() {

    }

    //发送 get GsonRequest 请求
    private void sendGetGsonRequest() {
        String url = "http://rapapi.org/mockjsdata/25158/api/orders/test";
        EncapsulationHttpUtilsExample.sendGetGsonRequest(url, this, Order.class,  new Response.Listener<Order>() {
            @Override
            public void onResponse(Order order) {
                Log.d("Tag:debug", order.getMessage());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Tag:error", error.toString());
            }
        });
    }

    //发送 post GsonRequest 请求
    private void sendPostGsonRequest() {
        // 其中传递的 params 参数可以为 JsonObject | JsonArray | Object
        String url = "http://rapapi.org/mockjsdata/25158/api/orders/test";
        JSONObject params = new JSONObject();
        params.put("lineID", "189");

        EncapsulationHttpUtilsExample.sendPostGsonRequest(url, this, Order.class, params,  new Response.Listener<Order>() {
            @Override
            public void onResponse(Order order) {
                Log.d("Tag:debug", order.getMessage());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Tag:error", error.toString());
            }
        });
    }

```

### 其他使用方法，待添加。。。。


