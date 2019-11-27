package com.example.islamgsayed.firstapp;

/**
 * Created by Islam.G sayed on 6/20/2018.
 */

public class phinfo  {


 private    String name ;
    private String address;
//    String id;

    public phinfo(String name, String address) {
        this.name = name;
        this.address = address;
//        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public void setId(String id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }


}
