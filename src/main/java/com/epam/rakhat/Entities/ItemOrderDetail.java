package com.epam.rakhat.Entities;


public class ItemOrderDetail {
    private int id;
    private String order_date;
    private int count;
    private int cost;
    private int item_id;

    public void setId (int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setOrderDate(String order_date){
        this.order_date = order_date;
    }

    public String getOrderDate(){
        return order_date;
    }

    public void setCount(int count){
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public int getCost(){
        return cost;
    }

    public void setItemId(int item_id){
        this.item_id = item_id;
    }

    public int getItemId(){
        return item_id;
    }

}