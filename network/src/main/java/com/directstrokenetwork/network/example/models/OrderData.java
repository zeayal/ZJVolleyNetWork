package com.directstrokenetwork.network.example.models;

import java.util.ArrayList;

/**
 * Created by mbp on 31/08/2017.
 */

public class OrderData {
    /**
     * 测试接口
     * url: http://rapapi.org/mockjsdata/25158/api/orders
     * 请求方式： GET
     * return 数据 |
     * {
        status: 200,
        data: {
            orders: [
                {
                    create_time: "3123213213",
                    id: 1
                },
                {
                    create_time: "3123213213",
                    id: 2
                },
                {
                    create_time: "3123213213",
                    id: 3
                }
            ]
        },
        message: "请求成功!"
        }
    * */
    private Number status;
    public String message;
    private Data data;

    public OrderData(Number status, String message, Data data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public class Data {
        private ArrayList<Order> orders;

        public Data(ArrayList<Order> orders) {
            this.orders = orders;
        }
    }

    public class Order {
        private Number id;
        private String create_time;

        public Order(Number id, String create_time) {
            this.id = id;
            this.create_time = create_time;
        }
    }


}
