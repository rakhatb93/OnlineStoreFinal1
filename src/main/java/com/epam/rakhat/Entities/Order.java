package com.epam.rakhat.Entities;

public class Order {
    private String order_id;
    private String order_date;
    private int user_id;
    private String date_created;
    private String date_finished;
    private String status;

    public void setOrderId(String order_id){
        this.order_id = order_id;
    }

    public String getOrderId(){
        return order_id;
    }

    public void setOrderDate(String order_date){
        this.order_date = order_date;
    }

    public String getOrderDate(){
        return order_date;
    }

    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    public int getUser_id(){
        return user_id;
    }

    public void setDateCreated(String date_created){
        this.date_created = date_created;
    }

    public String getDateCreated(){
        return date_created;
    }

    public void setDateFinished(String date_finished){
        this.date_finished = date_finished;
    }

    public String getDateFinished(){
        return date_finished;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
