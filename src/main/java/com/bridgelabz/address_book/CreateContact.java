package com.bridgelabz.address_book;

import java.util.Scanner;

/**
 * Instance variables are initialized in their particular methods
 */
public class CreateContact {
    String firstName, lastName, address, city, state, emailId, phoneNumber, zipcode;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    /**
     * show method is used to display the details filled
     * instance variables are used to display
     */
    public String show() {
        return "First name : " + firstName + "\nlast name : " + lastName + "\nAddress : " + address + "\nCity : " + city +
                "\nState : " + state + "\nEmail Id : " + emailId + "\nPhone number : " + phoneNumber + "\nZipcode : " + zipcode + "\n\n";
    }

    public String showCityOrState() {
        return city + " " + state;
    }

    /**
     * This method takes input from console
     *
     * @param sc input from user are set to their instance variables using respective methods
     */
    public void createContact(Scanner sc) {
        System.out.print("Enter First Name: ");
        setFirstName(sc.nextLine());
        System.out.print("Enter Last Name: ");
        setLastName(sc.nextLine());
        System.out.print("Enter Address: ");
        setAddress(sc.nextLine());
        System.out.print("Enter City: ");
        setCity(sc.nextLine());
        System.out.print("Enter state: ");
        setState(sc.nextLine());
        System.out.print("Enter Email Id: ");
        setEmailId(sc.nextLine());
        System.out.print("Enter Phone number: ");
        setPhoneNumber(sc.nextLine());
        System.out.print("Enter zipcode: ");
        setZipcode(sc.nextLine());
    }

    /**
     * This method returns string array as CSV data
     *
     * @return string array
     */
    public String[] CSVData() {
        return new String[]{firstName, lastName, address, city, state, emailId, phoneNumber, zipcode};
    }

    @Override
    public String toString() {
        return "\"[FirstName : " + firstName + ", LastName : " + lastName + ", Address : " + address +
                ", City : " + city + ", State : " + state + ", Email : " + emailId + ", Phone : " + phoneNumber +
                ", ZipCode : " + zipcode + "]";
    }
}