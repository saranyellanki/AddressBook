package com.bridgelabz.address_book;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressLibrary {

    static HashMap<String, AddressBook> addressBook = new HashMap<>();

    /**
     * This method is used to search contact in address book
     * count number of contacts in a city
     */
    public static void searchContact() {
        HashMap<String, String> cityPerson = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the city name to be searched : ");
        String cityName = sc.nextLine();
        int personCount = 0;
        for (Map.Entry<String, AddressBook> ab : addressBook.entrySet()) {
            AddressBook addressBookValue = ab.getValue();
            for (Map.Entry<String, CreateContact> c : addressBookValue.contacts.entrySet()) {
                String res = addressBookValue.contacts.get(c.getKey()).showCityOrState();
                if (res.contains(cityName)) {
                    cityPerson.put(c.getKey(), cityName);
                    personCount++;
                }
            }
        }
        for (Map.Entry<String, String> pc : cityPerson.entrySet()) {
            System.out.println("Name of Person : " + pc.getKey());
        }
        System.out.println("Number of persons in same city : " + personCount);
    }

    public static void main(String[] args) {
        addressBook.put("Address Book 1", new AddressBook());
        addressBook.put("Address Book 2", new AddressBook());
        addressBook.put("Address Book 3", new AddressBook());
        System.out.println("=========================");
        System.out.println("Welcome to Address Book");
        System.out.println("=========================");
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Press\n1.Address Book 1\n2.Address Book 2\n3.Address Book 3\n4.Search Persons by City\n5.Exit");
            int choose = sc.nextInt();
            String key = null;
            if (choose == 1) {
                key = "Address Book 1";
            } else if (choose == 2) {
                key = "Address Book 2";
            } else if (choose == 3) {
                key = "Address Book 3";
            } else if (choose == 4) {
                searchContact();
            } else break;
            System.out.println("Press\n1.To Create Contact\n2.Display Contact\n3.Edit Contact\n" +
                    "4.Delete contact\n5.SortByName\n6.SortByCity\n7.SortByState\n8.SortByZipcode\n9.To Exit");
            int option = sc.nextInt();
            sc.nextLine();
            CreateContact contact = new CreateContact();
            switch (option) {
                case 1 -> {
                    contact.createContact(sc);
                    String name = contact.firstName + " " + contact.lastName;
                    // Java stream operation is used to check for duplication
                    // if true else condition works , if false creates new contact in that particular address book
                    if (addressBook.get(key).contacts.keySet().stream().noneMatch(match -> match.equals(name))) {
                        addressBook.get(key).addContact(contact);
                    } else System.out.println("Duplicate contact already exist");
                }
                case 2 -> {
                    addressBook.get(key).displayContact();
                }
                case 3 -> {
                    addressBook.get(key).setEdit();
                }
                case 4 -> {
                    addressBook.get(key).deleteContact();
                }
                case 5 -> {
                    addressBook.get(key).sortEntriesByName();
                }
                case 6 -> {
                    addressBook.get(key).sortByCityName();
                }
                case 7 -> {
                    addressBook.get(key).sortByStateName();
                }
                case 8 -> {
                    addressBook.get(key).sortByZipCode();
                }
                default -> {
                    exit = true;
                }
            }
        }
    }
}
