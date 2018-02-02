package com.epam.rakhat.Entities;

public class User{
    private int id;
    private String phone_number;
    private String login;
    private String password;
    private String email;
    private int address_id;

    public User(int id, String phone_number, String login, String password, String email, int address_id) {
        this.id = id;
        this.phone_number = phone_number;
        this.login = login;
        this.password = password;
        this.email = email;
        this.address_id = address_id;
    }

    public User(){
    }

    public void setID(int id){
      this.id = id;
    }

    public int getID(){
        return id;
    }

    public void setPhoneNumber(String pnoneNumber){
        this.phone_number = phone_number;
    }

    public String getPhoneNumber(){
        return phone_number;
    }

    public void setLogin(String login){
        this.login=login;
    }

    public  String getLogin(){
        return login;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setAddress_id(int address_id){
        this.address_id = address_id;
    }

    public int getAddress_id(){
        return address_id;
    }
}
