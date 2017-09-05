package com.directstrokenetwork.a20170830;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.directstrokenetwork.network.example.EncapsulationHttpUtilsExample;
import com.directstrokenetwork.network.example.ZJModel.OrderList;
import com.directstrokenetwork.network.example.models.Order;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    // 创建一个内部类
    public class BagOfPrimitives {
        private int value1 = 1;
        private String value2 = "abc";
        private transient int value3 = 3;

        BagOfPrimitives() {

        }
    }

    private Button request_get_gson_btn;
    private Button request_post_gson_btn;

    private Button request_get_string_btn;
    private Button request_post_stringbtn;

    private TextView msg_tv;
    private Button gosnBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg_tv = (TextView) findViewById(R.id.msg_tv);

        request_get_string_btn = (Button) findViewById(R.id.send_get_request_btn);
        request_post_stringbtn = (Button) findViewById(R.id.send_post_request_btn);
        request_get_gson_btn = (Button) findViewById(R.id.send_get_gson_request_btn);
        request_post_gson_btn = (Button) findViewById(R.id.send_post_gson_request_btn);

        request_post_gson_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendZJRequest();
            }
        });

        // 测试 Gson
        gosnBtn = (Button) findViewById(R.id.gosn_btn);
        gosnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
//                int[] intDataArray = {1, 2, 3, 4};
                String jsonStr = gson.toJson(new BagOfPrimitives());
                BagOfPrimitives obj = gson.fromJson(jsonStr, BagOfPrimitives.class);

                // Collections Example
                ArrayList<Integer> ins = new ArrayList();
                Integer[] otherList = new Integer[] {1, 2, 3, 4, 5};
                ins.addAll(Arrays.asList(otherList));
                // Serialization
                String json = gson.toJson(ins);
//                msg_tv.setText(json);

                // Deserialization
                Type arrayListTypeToken = new TypeToken<ArrayList<Integer>>(){}.getType();
                ArrayList<Integer> arrayList = gson.fromJson(json, arrayListTypeToken);
                msg_tv.setText(arrayList.getClass().toString());
            }
        });
    }

    //发送 sendGsonPostRequest 请求
    private void sendGsonPostRequest() throws JSONException {

        String url = "http://rapapi.org/mockjsdata/25158/api/orders/test";
        JSONObject params = new JSONObject();
        params.put("lineID", "189");

        EncapsulationHttpUtilsExample.sendPostGsonRequest(url, this, Order.class, params,  new Response.Listener<Order>() {
            @Override
            public void onResponse(Order response) {
                Log.d("Tag:debug", response.getMessage());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Tag:error", error.toString());
            }
        });
    }

    //发送 post StringRequest 请求
    private void sendPostRequest() {

    }

    //发送 get GsonRequest 请求
    private void sendGetGsonRequest() {

    }

    //发送 get GsonRequest 请求
    private void sendPostGsonRequest() {

    }


    // 直击网络测试
    private void sendZJRequest() {
        String url = "http://192.168.1.23:90/api/v1.0/Order/GetOrderList";
        JSONObject params = new JSONObject();
        try {
            params.put("PageIndex", 1);
            params.put("PageSize", 5);
            params.put("OrderFlag", "");
            params.put("PayState", "");
            params.put("StartCreateDate", "");
            params.put("EndCreateDate", "");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        EncapsulationHttpUtilsExample.sendPostGsonRequest(url, this, OrderList.class, params,  new Response.Listener<OrderList>() {
            @Override
            public void onResponse(OrderList response) {
                Log.d("Tag:debug", response.getMessage());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Tag:error", error.toString());
            }
        });
    }

}
