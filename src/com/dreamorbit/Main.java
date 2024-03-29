package com.dreamorbit;

import com.dreamorbit.controller.AddressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Address Book");
        Scanner sc = new Scanner(System.in);
        ArrayList<AddressBook> addressBooks = new ArrayList<>();

        AddressBook addressBook = new AddressBook();
        boolean operation = true;
        while (operation) {
            System.out.println("Select the Operation:\n" +
                    "(i) Add Contact\n" +
                    "(ii) Get Contact By email\n" +
                    "(iii) Get all Contacts\n" +
                    "(iv) Edit Contact\n" +
                    "(v) Delete Contact\n" +
                    "(vi) Get Contact by City\n" +
                    "(vii) Get count of contact by city\n" +
                    "(viii) Get Contact by State\n" +
                    "(ix) Get count of contact by State\n" +
                    "(x) exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    addressBook.addContact();
                    break;

                case 2:
                    System.out.println("Enter the email id");
                    String email1 = sc.next();
                    addressBook.getContactByEmail(email1);
                    break;

                case 3:
                    addressBook.getAllContacts();
                    break;

                case 4:
                    addressBook.updateContact();
                    break;

                case 5:
                    System.out.println("Enter the email for delete the contact");
                    String deleteEmail = sc.next();
                    addressBook.deleteContact(deleteEmail);
                    break;

                case 6:
                    addressBook.contactByCity();
                    break;

                case 7:
                    addressBook.countInCity();
                    break;
                case 8:
                    addressBook.contactByState();
                    break;

                case 9:
                    addressBook.countInState();
                    break;

                case 10:
                    operation = false;
                    break;

                default:
                    System.out.println("Invalid input");
            }

        }
    }
}
