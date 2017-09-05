package com.directstrokenetwork.network.example.ZJModel;

import java.util.List;

/**
 * Created by mbp on 05/09/2017.
 */

public class OrderList {

    private Integer Status;
    private String Message;
    private List<Order> Orders;

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public List<Order> getOrders() {
        return Orders;
    }

    public void setOrders(List<Order> orders) {
        Orders = orders;
    }


    public class Order {
        public Integer getID() {
            return ID;
        }

        public void setID(Integer ID) {
            this.ID = ID;
        }

        public String getOrderNo() {
            return OrderNo;
        }

        public void setOrderNo(String orderNo) {
            OrderNo = orderNo;
        }

        public String getLineName() {
            return LineName;
        }

        public void setLineName(String lineName) {
            LineName = lineName;
        }

        public String getBeginDate() {
            return BeginDate;
        }

        public void setBeginDate(String beginDate) {
            BeginDate = beginDate;
        }

        public String getReturnDate() {
            return ReturnDate;
        }

        public void setReturnDate(String returnDate) {
            ReturnDate = returnDate;
        }

        public Integer getDays() {
            return Days;
        }

        public void setDays(Integer days) {
            Days = days;
        }

        public Integer getNights() {
            return Nights;
        }

        public void setNights(Integer nights) {
            Nights = nights;
        }

        public Integer getAdults() {
            return Adults;
        }

        public void setAdults(Integer adults) {
            Adults = adults;
        }

        public Integer getChilds() {
            return Childs;
        }

        public void setChilds(Integer childs) {
            Childs = childs;
        }

        public String getSetOutName() {
            return SetOutName;
        }

        public void setSetOutName(String setOutName) {
            SetOutName = setOutName;
        }

        public Integer getOrderFlag() {
            return OrderFlag;
        }

        public void setOrderFlag(Integer orderFlag) {
            OrderFlag = orderFlag;
        }

        public Integer getPayState() {
            return PayState;
        }

        public void setPayState(Integer payState) {
            PayState = payState;
        }

        public Integer getTradePrice() {
            return TradePrice;
        }

        public void setTradePrice(Integer tradePrice) {
            TradePrice = tradePrice;
        }

        public Integer getPrice() {
            return Price;
        }

        public void setPrice(Integer price) {
            Price = price;
        }

        public String getB2BComName() {
            return B2BComName;
        }

        public void setB2BComName(String b2BComName) {
            B2BComName = b2BComName;
        }

        public String getCreateUserName() {
            return CreateUserName;
        }

        public void setCreateUserName(String createUserName) {
            CreateUserName = createUserName;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String createTime) {
            CreateTime = createTime;
        }

        private Integer ID;
        private String OrderNo;
        private String LineName;
        private String BeginDate;
        private String ReturnDate;
        private Integer Days;
        private Integer Nights;
        private Integer Adults;
        private Integer Childs;
        private String SetOutName;
        private Integer OrderFlag;
        private Integer PayState;
        private Integer TradePrice;
        private Integer Price;
        private String B2BComName;
        private String CreateUserName;
        private String CreateTime;
    }
}
