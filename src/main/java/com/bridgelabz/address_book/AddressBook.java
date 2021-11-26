package com.bridgelabz.address_book;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class AddressBook {
    HashMap<String, CreateContact> contacts;
    List<CreateContact> contactNameIndex = new ArrayList<>();

    /**
     * constructor used for initializing hashmap
     */
    public AddressBook() {
        contacts = new HashMap<>();
    }

    /**
     * key value pairs of hashmap are assigned
     *
     * @param contact which is of CreateContact type
     */
    public void addContact(CreateContact contact) {
        contacts.put(contact.firstName + " " + contact.lastName, contact);
        contactNameIndex.add(contact);
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

    /**
     * This method sorts all the contacts in a particular address book by their firstnames
     * java streams are used to sort and forEach to print contacts
     */
    public void sortEntriesByName() {
        List<CreateContact> contactsSortByName = contactNameIndex.stream().
                sorted(Comparator.comparing(CreateContact::getFirstName)).
                collect(Collectors.toList());
        contactsSortByName.forEach(contact -> System.out.println(contact.getFirstName()));
    }
    /**
     * This method sorts all the contacts in a particular address book by their city
     * java streams are used to sort and forEach to print contacts
     */
    public void sortByCityName(){
        List<CreateContact> contactsSortByName = contactNameIndex.stream().
                sorted(Comparator.comparing(CreateContact::getCity)).
                collect(Collectors.toList());
        contactsSortByName.forEach(contact -> System.out.println(contact.getFirstName()+" "+contact.getCity()));
    }
    /**
     * This method sorts all the contacts in a particular address book by their state
     * java streams are used to sort and forEach to print contacts
     */
    public void sortByStateName(){
        List<CreateContact> contactsSortByName = contactNameIndex.stream().
                sorted(Comparator.comparing(CreateContact::getState)).
                collect(Collectors.toList());
        contactsSortByName.forEach(contact -> System.out.println(contact.getFirstName()+" "+contact.getState()));
    }
    /**
     * This method sorts all the contacts in a particular address book by their zipcode
     * java streams are used to sort and forEach to print contacts
     */
    public void sortByZipCode(){
        List<CreateContact> contactsSortByName = contactNameIndex.stream().
                sorted(Comparator.comparing(CreateContact::getZipcode)).
                collect(Collectors.toList());
        contactsSortByName.forEach(contact -> System.out.println(contact.getFirstName()+ " "+contact.getZipcode()));
    }
}