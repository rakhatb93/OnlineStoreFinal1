package com.epam.rakhat.Entities;

public class Item {
    private int item_id;
    private String  item_title;

    public void setItemId(int item_id){
        this.item_id = item_id;
    }

    public int getItemId(){
        return item_id;
    }

    public void setItemTypeId(String item_title){
        this.item_title = item_title;
    }

    public String getItemTypeId(){
        return item_title;
    }

}
