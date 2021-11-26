package com.bridgelabz.address_book;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
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

    /**
     * This method is used for reading the file
     *
     * @throws IOException for FileReader
     */
    public static void readFromFile() throws IOException {
        String data;
        BufferedReader br1 = new BufferedReader(new FileReader("/home/hp/Desktop/PROJECTS/AddressBook/AddressBook1.txt"));
        System.out.println("Address Book 1");
        while ((data = br1.readLine()) != null) {
            System.out.print(data);
            System.out.println();
        }
        BufferedReader br2 = new BufferedReader(new FileReader("/home/hp/Desktop/PROJECTS/AddressBook/AddressBook2.txt"));
        System.out.println("Address Book 2");
        while ((data = br2.readLine()) != null) {
            System.out.print(data);
            System.out.println();
        }
        BufferedReader br3 = new BufferedReader(new FileReader("/home/hp/Desktop/PROJECTS/AddressBook/AddressBook3.txt"));
        System.out.println("Address Book 3");
        while ((data = br3.readLine()) != null) {
            System.out.print(data);
            System.out.println();
        }
    }

    /**
     * This method is used to read CSV file
     *
     * @throws IOException            for FileReader
     * @throws CsvValidationException for CSVReader
     */
    public static void readCSVFile() throws IOException, CsvValidationException {
        String[] data;
        CSVReader csvReader1 = new CSVReader(new FileReader("/home/hp/Desktop/PROJECTS/AddressBook/AddressBook1.csv"));
        System.out.println("Address Book 1");
        while ((data = csvReader1.readNext()) != null) {
            for (String str : data) {
                System.out.print(str + "\t");
            }
            System.out.println();
        }
        CSVReader csvReader2 = new CSVReader(new FileReader("/home/hp/Desktop/PROJECTS/AddressBook/AddressBook2.csv"));
        System.out.println("Address Book 2");
        while ((data = csvReader2.readNext()) != null) {
            for (String str : data) {
                System.out.print(str + "\t");
            }
            System.out.println();
        }
        CSVReader csvReader3 = new CSVReader(new FileReader("/home/hp/Desktop/PROJECTS/AddressBook/AddressBook3.csv"));
        System.out.println("Address Book 3");
        while ((data = csvReader3.readNext()) != null) {
            for (String str : data) {
                System.out.print(str + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException, CsvValidationException {
        BufferedWriter bw1 = new BufferedWriter(new FileWriter("/home/hp/Desktop/PROJECTS/AddressBook/AddressBook1.txt"));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("/home/hp/Desktop/PROJECTS/AddressBook/AddressBook2.txt"));
        BufferedWriter bw3 = new BufferedWriter(new FileWriter("/home/hp/Desktop/PROJECTS/AddressBook/AddressBook3.txt"));
        CSVWriter book1 = new CSVWriter(new FileWriter("/home/hp/Desktop/PROJECTS/AddressBook/AddressBook1.csv"));
        CSVWriter book2 = new CSVWriter(new FileWriter("/home/hp/Desktop/PROJECTS/AddressBook/AddressBook2.csv"));
        CSVWriter book3 = new CSVWriter(new FileWriter("/home/hp/Desktop/PROJECTS/AddressBook/AddressBook3.csv"));
        String[] header = {"First Name", "Last Name", "Address", "city", "state", "emailId", "phoneNumber", "zipcode"};
        book1.writeNext(header);
        book2.writeNext(header);
        book3.writeNext(header);
        addressBook.put("Address Book 1", new AddressBook());
        addressBook.put("Address Book 2", new AddressBook());
        addressBook.put("Address Book 3", new AddressBook());
        System.out.println("=========================");
        System.out.println("Welcome to Address Book");
        System.out.println("=========================");
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    Press
                    1.Address Book 1
                    2.Address Book 2
                    3.Address Book 3
                    4.Search Contact by City
                    5.Exit""");
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
            System.out.println("""
                    Press
                    1.To Create Contact
                    2.Display Contact
                    3.Edit Contact
                    4.Delete contact
                    5.SortByName
                    6.SortByCity
                    7.SortByState
                    8.SortByZipcode
                    9.To Exit""");
            int option = sc.nextInt();
            sc.nextLine();
            CreateContact contact = new CreateContact();
            switch (option) {
                case 1 -> {
                    contact.createContact(sc);
                    String name = contact.firstName + " " + contact.lastName;
                    if (addressBook.get(key).contacts.keySet().stream().noneMatch(match -> match.equals(name))) {
                        addressBook.get(key).addContact(contact);
                        switch (choose) {
                            case 1 -> {
                                bw1.write(contact.show());
                                book1.writeNext(contact.CSVData());
                            }
                            case 2 -> {
                                bw2.write(contact.show());
                                book2.writeNext(contact.CSVData());
                            }
                            case 3 -> {
                                bw3.write(contact.show());
                                book3.writeNext(contact.CSVData());
                            }
                        }
                    } else System.out.println("Duplicate contact already exist");
                }
                case 2 -> addressBook.get(key).displayContact();
                case 3 -> addressBook.get(key).setEdit();
                case 4 -> addressBook.get(key).deleteContact();
                case 5 -> addressBook.get(key).sortEntriesByName();
                case 6 -> addressBook.get(key).sortByCityName();
                case 7 -> addressBook.get(key).sortByStateName();
                case 8 -> addressBook.get(key).sortByZipCode();
                default -> exit = true;
            }
        }
        bw1.close();
        bw2.close();
        bw3.close();
        book1.close();
        book2.close();
        book3.close();
        readFromFile();
        readCSVFile();
    }
}
