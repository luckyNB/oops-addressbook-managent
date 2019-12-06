package com.addressbook.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Person {
    @NotNull(message = "firstName can not be null ")
    @NotEmpty(message = "firstName can not be Empty")
    @Pattern(regexp = "[A-Z][a-zA-Z][^#&<>\\\"~;$^%{}?]{1,20}$")
    private String firstName;

    @NotNull(message = "lastName can not be null ")
    @NotEmpty(message = "lastName can not be Empty")
    @Pattern(regexp = "[A-Z][a-zA-Z][^#&<>\\\"~;$^%{}?]{1,20}$")
    private String lastName;

    @NotNull(message = "mobileNo can not be null ")
    @NotEmpty(message = "mobileNo can not be Empty")
    @Pattern(regexp = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$\n")
    private String phoneNumber;

    @NotNull(message = "city can not be null ")
    @NotEmpty(message = "city can not be Empty")
    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$")
    private String city;

    @NotNull(message = "mobileNo can not be null ")
    @NotEmpty(message = "mobileNo can not be Empty")
    @Pattern(regexp = "^[1-9][0-9]{6}$\n")
    private String zip;

    @NotNull(message = "mobileNo can not be null ")
    @NotEmpty(message = "mobileNo can not be Empty")
    @Pattern(regexp = "[A-Z][a-zA-Z][^#&<>\\\"~;$^%{}?]{1,20}$")
    private String state;

    public Person(String firstName, String lastName, String phoneNumber, String city, String zip, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.zip = zip;
        this.state = state;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
