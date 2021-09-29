package com.pluralsight.builder;

public class UserBuilder {
    private String firstName, lastName, phone, address;
    private Integer age;

    public UserBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder age(Integer age) {
        this.age = age;
        return this;
    }


    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }

    private void validate() {
        if (lastName == null) {
            throw new NullPointerException("LastName missing");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative " + age);
        }
    }

    public User build() {
        validate();
        return new User(firstName, lastName, age, phone, address);
    }

}
