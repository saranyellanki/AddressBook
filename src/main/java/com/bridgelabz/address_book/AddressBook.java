package com.bridgelabz.address_book;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    HashMap<String, CreateContact> contacts;
    /**
     * constructor used for initializing hashmap
     */
    public AddressBook() {
        contacts = new HashMap<>();
    }

    /**
     * key value pairs of hashmap are assigned
     * @param contact which is of CreateContact type
     */
    public void addContact(CreateContact contact) {
        contacts.put(contact.firstName + " " + contact.lastName, contact);
    }

    /**
     * This method displays the contact details if the contact exist in address book
     */
    public void displayContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your first name and last name with space : ");
        String name = sc.nextLine();
        if (contacts.containsKey(name)) {
            contacts.get(name).show();
        } else System.out.println("Record not present");
    }

    /**
     * This method allows user to edit details with help of name
     * Switch case used for edit only particular detail and set new value
     */
    public void setEdit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = sc.nextLine();
        if (contacts.containsKey(name)) {
            System.out.println("Enter a number you want to edit\n1.Address\n2.City\n3.State\n4.EmailId\n5.Phone Number\n6.Zipcode");
            int number = sc.nextInt();
            sc.nextLine();
            switch (number) {
                case 1 -> {
                    System.out.println("Enter new Address");
                    contacts.get(name).setAddress(sc.nextLine());
                }
                case 2 -> {
                    System.out.println("Enter new City");
                    contacts.get(name).setCity(sc.nextLine());
                }
                case 3 -> {
                    System.out.println("Enter new State");
                    contacts.get(name).setState(sc.nextLine());
                }
                case 4 -> {
                    System.out.println("Enter new EmailId");
                    contacts.get(name).setEmailId(sc.nextLine());
                }
                case 5 -> {
                    System.out.println("Enter new Phone number");
                    contacts.get(name).setPhoneNumber(sc.nextLine());
                }
                case 6 -> {
                    System.out.println("Enter new Zipcode");
                    contacts.get(name).setZipcode(sc.nextLine());
                }
                default -> System.out.println("Please input a valid number (1-6)");
            }
        } else System.out.println("Record not found");
    }

    /**
     * This method deletes the contact using name of the contact
     * hashmap remove method is used to remove the key
     */
    public void deleteContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = sc.nextLine();
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact deleted");
        } else System.out.println("Record not found");
    }

    public static void main(String[] args) {
        System.out.println("=========================");
        System.out.println("Welcome to Address Book");
        System.out.println("=========================");
        HashMap<String, AddressBook> addressBook =new HashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        AddressBook addressBook1 = new AddressBook();
        AddressBook addressBook2 = new AddressBook();
        AddressBook addressBook3 = new AddressBook();
        addressBook.put("Address Book 1",addressBook1);
        addressBook.put("Address Book 2",addressBook2);
        addressBook.put("Address Book 3",addressBook3);
        while (!exit) {
            System.out.println("Press\n1.Address Book 1\n2.Address Book 2\n3.Address Book 3\n4.Exit");
            int choose = sc.nextInt();
            if(choose==4) break;
            System.out.println("Press\n1.To Create Contact\n2.Display Contact\n3.Edit Contact\n4.Delete contact\n5.To Exit");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> {
                    CreateContact contact = new CreateContact();
                    if(choose==1){
                        contact.createContact(sc);
                        addressBook1.addContact(contact);
                    }else if(choose==2){
                        contact.createContact(sc);
                        addressBook2.addContact(contact);
                    }else if(choose==3){
                        contact.createContact(sc);
                        addressBook3.addContact(contact);
                    }else System.out.println("Address Book not found");
                }
                case 2 -> {
                    if(choose==1) addressBook1.displayContact();
                    else if(choose==2) addressBook2.displayContact();
                    else if(choose==3) addressBook3.displayContact();
                    else System.out.println("Record not found");
                }
                case 3 -> {
                    if(choose==1) addressBook1.setEdit();
                    else if(choose==2) addressBook2.setEdit();
                    else if(choose==3) addressBook3.setEdit();
                    else System.out.println("Record not found");
                }
                case 4 -> {
                    if(choose==1) addressBook1.deleteContact();
                    else if(choose==2) addressBook2.deleteContact();
                    else if(choose==3) addressBook3.deleteContact();
                    else System.out.println("Record not found");
                }
                default -> {
                    exit = true;
                }
            }
        }
    }
}