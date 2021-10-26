package com.bridgelabz.address_book;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    HashMap<String, CreateContact> addressBook;

    public AddressBook(){
        addressBook = new HashMap<>();
    }
    public void addContact(CreateContact contact){
        addressBook.put(contact.firstName + " " + contact.lastName, contact);
    }
    public void displayContact(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = sc.nextLine();
        if(addressBook.containsKey(name)) {
            addressBook.get(name).show();
        }else System.out.println("Record not present");
    }

    public void setEdit(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = sc.nextLine();
        if(addressBook.containsKey(name)) {
            System.out.println("Enter a number you want to edit\n1.Address\n2.City\n3.State\n4.EmailId\n5.Phone Number\n6.Zipcode");
            int number = sc.nextInt();
            sc.nextLine();
            switch (number){
                case 1 -> {
                    System.out.println("Enter new Address");
                    addressBook.get(name).setAddress(sc.nextLine());
                }
                case 2 -> {
                    System.out.println("Enter new City");
                    addressBook.get(name).setCity(sc.nextLine());
                }
                case 3 -> {
                    System.out.println("Enter new State");
                    addressBook.get(name).setState(sc.nextLine());
                }
                case 4 -> {
                    System.out.println("Enter new EmailId");
                    addressBook.get(name).setEmailId(sc.nextLine());
                }
                case 5 -> {
                    System.out.println("Enter new Phone number");
                    addressBook.get(name).setPhoneNumber(sc.nextLine());
                }
                case 6 -> {
                    System.out.println("Enter new Zipcode");
                    addressBook.get(name).setZipcode(sc.nextLine());
                }
                default -> System.out.println("Please input a valid number (1-6)");
            }
        }else System.out.println("Record not found");

    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        AddressBook addressBook = new AddressBook();
        while (!exit) {
            System.out.println("Press\n1.To Create Contact\n2.Display Contact\n3.Edit Contact\n4.To Exit");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> {
                    CreateContact contact = new CreateContact();
                    contact.createContact(sc);
                    addressBook.addContact(contact);
                    System.out.println("Entry Successful");
                }
                case 2 -> {
                    addressBook.displayContact();
                }
                case 3 -> {
                    addressBook.setEdit();
                }
                default -> {
                    exit = true;
                }
            }
        }
    }
}
