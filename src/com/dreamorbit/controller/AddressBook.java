package com.dreamorbit.controller;

import com.dreamorbit.entity.Contact;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Contact> contactList = new ArrayList<>();
    Contact contact;
    Scanner sc = new Scanner(System.in);



    public void addContact() {
        setContact();
        if (contactList.stream().noneMatch(e -> e.getEmail().equals(contact.getEmail()))) {
            contactList.add(contact);
        } else {
            System.out.println("Email already present");
        }


    }



    public void getAllContacts() {
        contactList.forEach(System.out::println);
    }



    public void getContactByEmail(String email) {
        boolean isPresent = false;
        for (Contact c : contactList) {
            if (c.getEmail().equals(email)) {
                System.out.println(c);
                isPresent = true;
                break;
            }
        }
        if (!isPresent) {
            System.out.println("Email Id is not present");
        }


    }



    public void updateContact() {
        System.out.println("Enter the email ID to update the contact");
        String updateEmail = sc.next();
        boolean isPresent = false;
        for (Contact c : contactList) {
            if (c.getEmail().equals(updateEmail)) {
                isPresent = true;
                contact = c;
                break;
            }
        }
        if (isPresent) {
            updatingContact();
            contactList.replaceAll(e -> {
                if (e.getEmail().equals(contact.getEmail())) {
                    return contact;
                } else {
                    return e;
                }
            });
        } else {
            System.out.println("email not present");
        }
    }



    private void updatingContact() {
        boolean operation = true;
        while (operation) {
            System.out.println("(i) Change the First name\n" +
                    "(ii) Change the Last name\n" +
                    "(iii) Change the Email\n" +
                    "(iv) Change the number\n" +
                    "(v) Change the address\n" +
                    "(vi) Change the city\n" +
                    "(vii) Change the state\n" +
                    "(viii) Change the pin code\n" +
                    "(ix) exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the new firstName");
                    contact.setFirstName(sc.next());
                    break;

                case 2:
                    System.out.println("Enter the new LastName");
                    contact.setLastName(sc.next());
                    break;

                case 3:
                    System.out.println("Enter the new Email");
                    contact.setEmail(sc.next());
                    break;

                case 4:
                    System.out.println("Enter the new phoneNumber");
                    contact.setPhoneNumber(sc.nextLong());
                    break;

                case 5:
                    sc.nextLine();
                    System.out.println("Enter the new address");
                    contact.setAddress(sc.nextLine());
                    break;

                case 6:
                    System.out.println("Enter the new city");
                    contact.setCity(sc.next());
                    break;

                case 7:
                    System.out.println("Enter the new state");
                    contact.setState(sc.next());
                    break;

                case 8:
                    System.out.println("Enter the new pinCode");
                    contact.setPinCode(sc.nextInt());
                    break;

                case 9:
                    operation = false;
                    break;

                default:
            }
        }
    }




    public void deleteContact(String email) {
        boolean isTrue = contactList.removeIf(value -> value.getEmail().equals(email));
        if (!isTrue) {
            System.out.println("Email not Present");
        }
    }




    public void setContact() {
        contact = new Contact();
        System.out.println("Enter the firstName");
        contact.setFirstName(sc.next());

        System.out.println("Enter the LastName");
        contact.setLastName(sc.next());

        System.out.println("Enter the Email");
        contact.setEmail(sc.next());


        System.out.println("Enter the phoneNumber");
        contact.setPhoneNumber(sc.nextLong());
        sc.nextLine();

        System.out.println("Enter the address");
        contact.setAddress(sc.nextLine());

        System.out.println("Enter the city");
        contact.setCity(sc.next());

        System.out.println("Enter the state");
        contact.setState(sc.next());

        System.out.println("Enter the pinCode");
        contact.setPinCode(sc.nextInt());
    }



    public void contactByCity(){
        System.out.println("Enter the city");
        String city = sc.next();
        boolean isPresent = contactList.stream().noneMatch(contact1 -> contact1.getCity().equals(city));
        contactList.stream()
                .filter(contact1 -> contact1.getCity().equalsIgnoreCase(city))
                .forEach(e-> System.out.println(e.getFirstName()+" "+e.getLastName()));
        if(isPresent)
            System.out.println("No one is in this location");
    }


    public void contactByState(){
        System.out.println("Enter the state");
        String state = sc.next();
        boolean isPresent = contactList.stream().noneMatch(contact1 -> contact1.getState().equals(state));
        contactList.stream()
                .filter(contact1 -> contact1.getState().equalsIgnoreCase(state))
                .forEach(e-> System.out.println(e.getFirstName()+" "+e.getLastName()));
        if(isPresent)
            System.out.println("No one is in this location");
    }

    public void countInState(){
        System.out.println("Enter the State");
        String state = sc.next();
        System.out.println("Number of contact in "+state+" is :"+ contactList.stream().filter(contact1 -> contact1.getState().equals(state)).count());
    }

    public void countInCity(){
        System.out.println("Enter the city");
        String city = sc.next();
        System.out.println("Number of contact in "+city+" is :"+ contactList.stream().filter(contact1 -> contact1.getCity().equals(city)).count());
    }
}
