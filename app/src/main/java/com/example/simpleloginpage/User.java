package com.example.simpleloginpage;

import java.util.ArrayList;

public class User {
    private String User_Name;
    private String Email;
    private String Phone_Number;
    private String Password;
    private ArrayList<User> User_List;

    public User(String user_Name, String email, String phone_Number, String password) {
        this.User_Name = user_Name;
        this.Email = email;
        this.Phone_Number = phone_Number;
        this.Password = password;
    }

    public String getUser_Name() {
        return this.User_Name;
    }

    public void setUser_Name(String user_Name) {
        this.User_Name = user_Name;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPhone_Number() {
        return this.Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.Phone_Number = phone_Number;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public ArrayList<User> getUser_List() {
        return this.User_List;
    }

    public void setUser_List(ArrayList<User> user_List) {
        this.User_List = user_List;
    }

    public void addUser(User user){
        this.User_List.add(user);
    }
}
