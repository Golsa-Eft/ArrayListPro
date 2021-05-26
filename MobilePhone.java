package com.company;

import java.util.ArrayList;

//create a master class that holds the arrayList of Contacts

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContact;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContact = new ArrayList<Contact>();
    }

    //we need a method when adding or updating be sure to check of the contact already exists (use name)
    public boolean addNewContact(Contact contact){
        if (findContact(contact.getName()) >= 0){
            System.out.println("Contact is alredy on file!");
            return false;
        }

        myContact.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldcontact, Contact newContact){
        //search for index oldContect
        int foundPsition = findContact(oldcontact);
        if (foundPsition<0){
            System.out.println(oldcontact.getName() +" , was not found.");
            return false;
        }
        this.myContact.set(foundPsition, newContact);
        System.out.println(oldcontact.getName() + " , was replaced with " + newContact.getName());
        return true;
    }

    //only used in this class so use private
    // >=0 exist & <0 doesn't exist
    //وقتی ورودی کلاس یعنی میتونیم هم براساس نام و هم براساس شماره وردی بهش بدیم
    private int findContact(Contact contact){
        return this.myContact.indexOf(contact);
    }

    private int findContact(String contactName){
        for (int i=0; i<myContact.size(); i++){
            Contact contact = this.myContact.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    //if founded this contact then return its name
    public String queryContact(Contact contact){
        if(findContact(contact) >0){
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return this.myContact.get(position);
        }
        return null;
    }

    //ابتدا ایندکس ورودی رو پیدا میکنیم اگر وجو داشت از لیست ارایه حذفش میکنیم. اگر وجود نداشت بهش پیام میدیم
    public boolean removeContact(Contact contact){
        int indexContact = findContact(contact);
        if (indexContact<0){
            System.out.println(contact.getName()+ " , was not found.");
            return false;
        }
        this.myContact.remove(indexContact);
        System.out.println(contact.getName()+ " , was deleted.");
        return true;
        }

    public void printContacts(){
        System.out.println("Contact List");
        for(int i=0; i<this.myContact.size(); i++){
            System.out.println((i+1) + "." +
                    this.myContact.get(i).getName() + "->" +
                    this.myContact.get(i).getPhoneNumber());
        }
    }
    }

