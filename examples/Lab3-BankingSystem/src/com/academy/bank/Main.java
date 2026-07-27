package com.academy.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService(scanner);

        while (true) {
            bankService.displayMenu();
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1 -> bankService.createCustomer();
                    case 2 -> bankService.createSavingsAccount();
                    case 3 -> bankService.createCurrentAccount();
                    case 4 -> bankService.deposit();
                    case 5 -> bankService.withdraw();
                    case 6 -> bankService.displayAccounts();
                    case 7 -> bankService.displayCustomers();
                    case 8 -> {
                        System.out.println("Thank You");
                        scanner.close();
                        return;
                    }
                    default -> {System.out.println("Invalid Input");
                        System.out.println("Please Try Again.");}
                }
            } catch (NumberFormatException exception) {
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
    }
}
