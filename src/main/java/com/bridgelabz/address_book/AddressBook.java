package com.bridgelabz.address_book;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    HashMap<String, CreateContact> addressBook;

    /**
     * constructor used for initializing hashmap
     */
    public AddressBook(){
        addressBook = new HashMap<>();
    }

    /**
     * key value pairs of hashmap are assigned
     * @param contact which is of CreateContact type
     */
    public void addContact(CreateContact contact){
        addressBook.put(contact.firstName + " " + contact.lastName, contact);
    }

    /**
     * This method displays the contact details if the contact exist in address book
     */
    public void displayContact(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your first name and last name with space : ");
        String name = sc.nextLine();
        if(addressBook.containsKey(name)) {
            addressBook.get(name).show();
        }else System.out.println("Record not present");
    }

    /**
     * This method allows user to edit details with help of name
     * Switch case used for edit only particular detail and set new value
     */
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

    /**
     * This method deletes the contact using name of the contact
     * hashmap remove method is used to remove the key
     */
    public void deleteContact(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = sc.nextLine();
        if(addressBook.containsKey(name)){
            addressBook.remove(name);
            System.out.println("Contact deleted");
        }else System.out.println("Record not found");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        AddressBook addressBook = new AddressBook();
        while (!exit) {
            System.out.println("Press\n1.To Create Contact\n2.Display Contact\n3.Edit Contact\n4.Delete contact\n5.To Exit");
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
                case 4 -> {
                    addressBook.deleteContact();
                }
                default -> {
                    exit = true;
                }
            }
        }
    }
}