package com.bridgelabz.address_book;

import java.util.Scanner;

/**
 * Instance variables are initialized in their particular methods
 */
public class CreateContact {
    String firstName, lastName, address, city, state, emailId, phoneNumber, zipcode;
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setState(String state){
        this.state = state;
    }
    public void setEmailId(String emailId){
        this.emailId = emailId;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setZipcode(String zipcode){
        this.zipcode = zipcode;
    }

    /**
     * show method is used to display the details filled
     * instance variables are used to display
     */
    public void show(){
        System.out.println("First name : " + firstName);
        System.out.println("last name : " +lastName);
        System.out.println("Address : " +address);
        System.out.println("City : " +city);
        System.out.println("State : " +state);
        System.out.println("Email Id : " +emailId);
        System.out.println("Phone number : " +phoneNumber);
        System.out.println("Zipcode : "+zipcode);
    }

    /**
     * This method takes input from console
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
}