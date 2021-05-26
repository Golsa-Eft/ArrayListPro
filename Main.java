package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner =new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0936 186 2788");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printAction();
        while(!quit){
            System.out.println("\nEnter action: (6 to show available)");
            int action = scanner.nextInt();

            switch (action){
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printAction();
                    break;


            }

        }
    }

    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = scanner.next();
        System.out.println("Enter phone number: ");
        String phone = scanner.next();
        Contact newContact = Contact.createContact(name, phone);
        if (mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added: name = " + name + " phone number = " + phone);
        }
        else
            System.out.println("Can not add, " + name + "alredy exist!");
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.next();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new contact nema: ");
        String newName = scanner.next();
        System.out.println("Enter new phone nember: ");
        String newPhoneNumber = scanner.next();
        Contact newContact = Contact.createContact(newName, newPhoneNumber);
        if (mobilePhone.updateContact(existingContactRecord,newContact))
            System.out.println("Successfully updated record");
        else
            System.out.println("Error updating record.");

    }

    //removing
    private static void removeContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.next();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("Contact not found.");
            return;
        }

        if (mobilePhone.removeContact(existingContactRecord))
            System.out.println("Successfully deleted.");
        else
            System.out.println("Error deleting record.");
    }

    //query
    private static void queryContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.next();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + "and phone number is: " + existingContactRecord.getPhoneNumber());
    }


    private static void startPhone(){
        System.out.println("Starting phone...");
    }
    private static void printAction(){
        System.out.println("\nAvailable action:\npress");
        System.out.println("0 - to shutdown\n"+
                            "1 - to print contact\n"+
                            "2 - to add a new contact\n"+
                            "3 - to update existing an existing contact\n"+
                            "4 - to remove an existing contact\n"+
                            "5 - query if an existing contact exists\n"+
                            "6 - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }
}
