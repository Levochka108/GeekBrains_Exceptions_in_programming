package com.levochka108.home.task3.model;

public class User {
    private String FirstName;
    private String LastName;
    private String Surname;

    private long PhoneNumber;

    public User(String firstName, String lastName, String surname, long phoneNumber) {
        FirstName = firstName;
        LastName = lastName;
        Surname = surname;
        PhoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getSurname() {
        return Surname;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }
}
