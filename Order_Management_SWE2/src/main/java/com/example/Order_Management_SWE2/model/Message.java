package com.example.Order_Management_SWE2.model;

public class Message {

    String Content;
    String MsgType;
    Order order;
    //    Notification notification;
    int NumOfPlaceholders;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

//    public Notification getNotification() {
//        return notification;
//    }
//
//    public void setNotification(Notification notification) {
//        this.notification = notification;
//    }

    public int getNumOfPlaceholders() {
        return NumOfPlaceholders;
    }

    public void setNumOfPlaceholders(int numOfPlaceholders) {
        NumOfPlaceholders = numOfPlaceholders;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}
