package com.epam.rakhat.Entities;


 public class Address {
     private int addressId;
     private int zipCode;
     private String country;
     private String city;
     private String street;

     public void setAddressId(int addressId){
        this.addressId = addressId;
    }

     public int getAddressId(){
        return addressId;
    }

     public void setZipCode(int length){
        this.zipCode = zipCode;
    }

     public  int getZipCode(){
        return zipCode;
    }

     public  void setCountry(String country){
        this.country = country;
    }

     public String getCountry(){
        return country;
    }

     public void setCity(String city){
        this.city = city;
    }

     public String getCity(){
        return city;
    }

     public void setStreet(String street){
        this.street = street;
    }

}

