package com.example.islamgsayed.firstapp;

/**
 * Created by Islam.G sayed on 6/3/2018.
 */

public class UserInformation {

    public String name;
    public String email;
    public String phone;
    public String age;
    //public String address;
    //public String password;

    public UserInformation() {
    }

    public UserInformation(String name, String email, String phone, String age) {
        //  this.password=password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        //  this.address = address;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(String age) {
        this.age = age;
    }

   /*public void setAddress(String address) {
        this.address = address;
    }*/

    public String getName() {

        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAge() {
        return age;
    }

  /*  public String getAddress() {
        return address;
    }*/
}
