package com.novare.aa.ip.model;

public class User {

    private String firstName;
    private String lastName;
    private String userID;
    private static int globalTaskID = 0;

    public User(String firstName, String lastName) {
        globalTaskID++;
        this.userID = Integer.toString(globalTaskID);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
}
