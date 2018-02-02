package com.epam.rakhat.Entities;

public class Characteristics {
    private int id;
    private int item_id;
    private int language_id;
    private String  item_title;
    private String value;

    public void setId(int id){
        this.id = id;
    }

    public void setItemId(int item_id){
        this.item_id = item_id;
    }

    public void setLanguageId(int language_id){
        this.language_id = language_id;
    }

    public void setItemTitle(String item_title){
        this.item_title = item_title;
    }

    public void setValue(String value){
        this.value = value;
    }

    public int getId(){
        return id;
    }

    public int getItemId(){
        return item_id;
    }

    public int getLanguageId(){
        return language_id;
    }

    public String getItemTitle(){
        return item_title;
    }

    public String  getValue(){
        return value;
    }
}
