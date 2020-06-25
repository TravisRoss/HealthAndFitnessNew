package com.example.healthandfitnessnew;

public class UserHelperClass {

    private String name, phoneNo, age, height, weight;

    //constructor
    public UserHelperClass(){

    }

    //initialise variables
    public UserHelperClass(String name, String phoneNo, String age, String height, String weight) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
