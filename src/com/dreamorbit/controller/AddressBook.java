package com.dreamorbit.controller;

import com.dreamorbit.entity.Contact;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Contact> contactList = new ArrayList<>();
    Contact contact;
    Scanner sc = new Scanner(System.in);
    public void addContact() {
        boolean isUpdating = false;
        setContact(isUpdating);
        if(contactList.stream().noneMatch(e -> e.getEmail().equals(contact.getEmail()))) {
            contactList.add(contact);
        }else {
            System.out.println("Email already present");
        }


    }

    public void getAllContacts(){
        contactList.forEach(System.out::println);
    }

    public void getContactByEmail(String email){
        boolean isPresent = false;
        for(Contact c : contactList){
            if(c.getEmail().equals(email)){
                System.out.println(c);
                isPresent = true;
                break;
            }
        }
        if (!isPresent){
            System.out.println("Email Id is not present");
        }


    }
    public void updateContact(){
        System.out.println("Enter the email ID to update the contact");
        String updateEmail = sc.next();
        boolean isPresent = false;
        for(Contact c : contactList){
            if(c.getEmail().equals(updateEmail)){
                isPresent = true;
                break;
            }
        }
        if(isPresent) {
            boolean isUpdating = true;
            setContact(isUpdating);
            contact.setEmail(updateEmail);

            contactList.replaceAll(e -> {
                if (e.getEmail().equals(contact.getEmail())) {
                    return contact;
                } else {
                    return e;
                }
            });
        }else {
            System.out.println("email not present");
        }
    }
    public void deleteContact(String email){
        boolean isTrue = contactList.removeIf(value -> value.getEmail().equals(email));
        if(!isTrue){
            System.out.println("Email not Present");
        }
    }

    public void setContact(boolean isUpdating){
        contact=new Contact();
        System.out.println("Enter the firstName");
        contact.setFirstName(sc.next());

        System.out.println("Enter the LastName");
        contact.setLastName(sc.next());

        if(!isUpdating) {
            System.out.println("Enter the Email");
            contact.setEmail(sc.next());
        }

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
}
