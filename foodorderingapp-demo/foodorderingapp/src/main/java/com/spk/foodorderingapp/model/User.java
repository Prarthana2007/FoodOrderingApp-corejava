package com.spk;

public class User {
    protected int userId;
    protected String name;
    protected String phoneNumber;
    protected String email;
    protected String role;
    
    public User(int userId, String name, String phoneNumber, String email, String role) {
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
    }
    public void login(){
       System.out.println("User logged in: " + name);

    }
    public void logout(){
        System.out.println("User logged out: " + name);

    }

    public int getUserId(){
        return userId;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getEmail(){
        return email;
    }

    public String getRole(){
        return role;
    }
}
