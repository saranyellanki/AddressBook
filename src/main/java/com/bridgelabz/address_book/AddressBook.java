package com.bridgelabz.address_book;

import java.util.*;

public class AddressBook extends CreateContact{
    HashMap<String, CreateContact> contacts;
    HashMap<String, AddressBook> addressBook =new HashMap<>();
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
            show();
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

    public void searchContact(){
        HashMap<String,String> cityPerson = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the city name to be searched : ");
        String cityName = sc.nextLine();
        int personCount = 0;
        for(Map.Entry<String,AddressBook> ab : addressBook.entrySet()){
            AddressBook addressBookValue = ab.getValue();
            for (Map.Entry<String,CreateContact> c : addressBookValue.contacts.entrySet()) {
                String res = addressBookValue.contacts.get(c.getKey()).showCityOrState();
                if(res.contains(cityName)){
                    cityPerson.put(c.getKey(),cityName);
                    personCount++;
                }
            }
        }
        for(Map.Entry<String,String> pc : cityPerson.entrySet()){
            System.out.println("Name of Person : "+pc.getKey());
        }
        System.out.println("Number of persons in same city : "+personCount);
    }

    public static void main(String[] args) {
        System.out.println("=========================");
        System.out.println("Welcome to Address Book");
        System.out.println("=========================");
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        AddressBook addressBookObj = new AddressBook();
        AddressBook addressBook1 = new AddressBook();
        AddressBook addressBook2 = new AddressBook();
        AddressBook addressBook3 = new AddressBook();
        addressBookObj.addressBook.put("Address Book 1",addressBook1);
        addressBookObj.addressBook.put("Address Book 2",addressBook2);
        addressBookObj.addressBook.put("Address Book 3",addressBook3);
        while (!exit) {
            System.out.println("Press\n1.Address Book 1\n2.Address Book 2\n3.Address Book 3\n4.Search Persons by City\n5.Exit");
            int choose = sc.nextInt();
            String key = null;
            if(choose==1){
                key = "Address Book 1";
            }else if(choose==2){
                key = "Address Book 2";
            }else if(choose==3) {
                key = "Address Book 3";
            }else if(choose==4){
                addressBookObj.searchContact();
            }else break;
            System.out.println("Press\n1.To Create Contact\n2.Display Contact\n3.Edit Contact\n4.Delete contact\n5.To Exit");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> {
                    CreateContact contact = new CreateContact();
                    contact.createContact(sc);
                    String name = contact.firstName + " " + contact.lastName;
                    // Java stream operation is used to check for duplication
                    // if true else condition works , if false creates new contact in that particular address book
                    if(addressBookObj.addressBook.get(key).contacts.keySet().stream().noneMatch(match -> match.equals(name))) {
                        addressBookObj.addressBook.get(key).addContact(contact);
                    }else System.out.println("Duplicate contact already exist");
                }
                case 2 -> {
                    addressBookObj.addressBook.get(key).displayContact();
                }
                case 3 -> {
                    addressBookObj.addressBook.get(key).setEdit();
                }
                case 4 -> {
                    addressBookObj.addressBook.get(key).deleteContact();
                }
                default -> {
                    exit = true;
                }
            }
        }
    }
}