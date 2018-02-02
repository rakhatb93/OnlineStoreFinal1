package com.epam.rakhat.Action;

import java.sql.SQLException;
import java.text.ParseException;

public class ActionException extends RuntimeException{
    private int details;

    public ActionException(int details){
        this.details = details;
    }

    public ActionException(SQLException e){
        super(e);
    }

    public ActionException(ParseException e){
    }

    public ActionException(Exception e){
        }

     public String toString(){
        return "ActionException{" + "detail = "+ details + '}';
     }
}
