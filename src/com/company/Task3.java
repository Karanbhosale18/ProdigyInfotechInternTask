package com.company;

import java.io.*;
import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + "," + phone + "," + email;
    }
}

public class Task3 {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static final String FILE_NAME = "contact.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadContacts();

        while (true) {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> editContact();
                case 4 -> deleteContact();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addContact() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully.");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            System.out.println((i + 1) + ". " + c.name + " | " + c.phone + " | " + c.email);
        }
    }

    static void editContact() {
        viewContacts();
        System.out.print("Enter contact number to edit: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        System.out.print("New Name: ");
        String name = sc.nextLine();
        System.out.print("New Phone: ");
        String phone = sc.nextLine();
        System.out.print("New Email: ");
        String email = sc.nextLine();

        contacts.set(index, new Contact(name, phone, email));
        System.out.println("Contact updated.");
    }

    static void deleteContact() {
        viewContacts();
        System.out.print("Enter contact number to delete: ");
        int index = sc.nextInt() - 1;

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        contacts.remove(index);
        System.out.println("Contact deleted.");
    }

    static void loadContacts() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                contacts.add(new Contact(data[0], data[1], data[2]));
            }
        } catch (IOException ignored) {}
    }

    }
