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
    public void displayContact(Scanner sc){
        System.out.print("Enter your name : ");
        String name = sc.nextLine();
        if(addressBook.containsKey(name)) {
            addressBook.get(name).show();
        }else System.out.println("Record not present");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        AddressBook addressBook = new AddressBook();
        while (!exit) {
            System.out.println("Press\n1.To Create Contact\n2.Display Contact\n3.Enter New Contact\n4.To Exit");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> {
                    CreateContact contact = new CreateContact();
                    contact.createContact(sc);
                    addressBook.addContact(contact);
                }
                case 2 -> {
                    addressBook.displayContact(sc);
                }
                case 3 -> {

                }
                default -> {
                    exit = true;
                }
            }
        }
    }
}
