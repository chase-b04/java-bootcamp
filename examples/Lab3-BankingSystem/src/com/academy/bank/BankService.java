package com.academy.bank;

import java.time.LocalDate;
import java.util.Scanner;

public class BankService {
    private static final int MAX_CUSTOMERS = 50;
    private static final int MAX_ACCOUNTS = 100;
    private static final int MAX_TRANSACTIONS = 500;

    private final Customer[] customers = new Customer[MAX_CUSTOMERS];
    private final Account[] accounts = new Account[MAX_ACCOUNTS];
    private final Transaction[] transactions = new Transaction[MAX_TRANSACTIONS];

    private int customerCount = 0;
    private int accountCount = 0;
    private int transactionCount = 0;
    private int nextAccountNumber = 10001;
    private int nextTransactionNumber = 1;

    private final Scanner scanner;

    public BankService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("====================================");
        System.out.println("Banking System");
        System.out.println("====================================");
        System.out.println("1. Create Customer");
        System.out.println("2. Create Savings Account");
        System.out.println("3. Create Current Account");
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Display Accounts");
        System.out.println("7. Display Customers");
        System.out.println("8. Exit");
        System.out.print("Enter Choice : ");
    }

    public void createCustomer() {
        if (customerCount == MAX_CUSTOMERS) {
            System.out.println("Customer storage is full.");
            return;
        }
        System.out.print("Customer ID : ");
        String customerId = scanner.nextLine().trim();
        if (findCustomer(customerId) != null) {
            System.out.println("Customer ID already exists.");
            return;
        }

        System.out.print("Name : ");
        String name = scanner.nextLine().trim();
        System.out.print("Email : ");
        String email = scanner.nextLine().trim();
        System.out.print("Phone : ");
        String phone = scanner.nextLine().trim();
        customers[customerCount] = new Customer(customerId, name, email, phone);
        customerCount++;
        System.out.println("Customer Created Successfully.");
    }

    public void createSavingsAccount() {
        if (accountCount == MAX_ACCOUNTS) {
            System.out.println("Account storage is full.");
            return;
        }
        Customer customer = readExistingCustomer();
        if (customer == null) {
            return;
        }

        double balance = readPositiveAmount("Initial Balance : ");
        double interestRate = readPositiveAmount("Interest Rate : ");
        String accountNumber = String.valueOf(nextAccountNumber);
        nextAccountNumber++;
        accounts[accountCount] = new SavingsAccount(accountNumber, balance, customer, interestRate);
        accountCount++;
        System.out.println("Savings Account Created.");
        System.out.println("Account Number : " + accountNumber);
        System.out.printf("Balance : %.2f%n", balance);
        System.out.printf("Interest Rate : %.2f%%%n", interestRate);
    }

    public void createCurrentAccount() {
        if (accountCount == MAX_ACCOUNTS) {
            System.out.println("Account storage is full.");
            return;
        }
        Customer customer = readExistingCustomer();
        if (customer == null) {
            return;
        }

        double balance = readPositiveAmount("Initial Balance : ");
        double transactionFee = readPositiveAmount("Transaction Fee : ");
        String accountNumber = String.valueOf(nextAccountNumber);
        nextAccountNumber++;
        accounts[accountCount] = new CurrentAccount(accountNumber, balance, customer, transactionFee);
        accountCount++;

        System.out.println("Current Account Created.");
        System.out.println("Account Number : " + accountNumber);
        System.out.printf("Balance : %.0f%n", balance);
        System.out.printf("Transaction Fee : %.0f%n", transactionFee);
    }

    public void deposit() {
        Account account = readExistingAccount();
        if (account == null) {return;}
        double amount = readPositiveAmount("Deposit Amount : ");
        account.deposit(amount);
        recordTransaction("Deposit", amount, account.getAccountNumber());
        System.out.printf("Balance Updated : %.2f%n", account.getBalance());
    }

    public void withdraw() {
        Account account = readExistingAccount();
        if (account == null) {return;}

        double amount = readPositiveAmount("Withdraw : ");
        double fee = account.calculateCharges();
        if (account.withdraw(amount)) {
            recordTransaction("Withdraw", amount, account.getAccountNumber());
            if (fee > 0) {
                System.out.printf("Transaction Fee : %.2f%n", fee);
                System.out.printf("Total Deducted : %.2f%n", amount + fee);
            }
            System.out.printf("Balance Updated : %.2f%n", account.getBalance());
        }
    }

    public void displayAccounts() {
        for (int i = 0; i < accountCount; i++) {
            accounts[i].displayAccount();
        }
    }

    public void displayCustomers() {
        for (int i = 0; i < customerCount; i++) {
            customers[i].display();
        }
    }

    public void displayTransactions() {
        for (int i = 0; i < transactionCount; i++) {
            transactions[i].display();
        }
    }

    private Customer findCustomer(String id) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId().equals(id)) {
                return customers[i];
            }
        }
        return null;
    }

    private Customer readExistingCustomer() {
        System.out.print("Customer ID : ");
        Customer customer = findCustomer(scanner.nextLine().trim());
        if (customer == null) {
            System.out.println("Customer not found.");
        }
        return customer;
    }

    private Account findAccount(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    private Account readExistingAccount() {
        System.out.print("Account Number : ");
        Account account = findAccount(scanner.nextLine().trim());
        if (account == null) {
            System.out.println("Account not found.");
        }
        return account;
    }

    private void recordTransaction(String type, double amount, String accountNumber) {
        if (transactionCount == MAX_TRANSACTIONS) {
            System.out.println("Transaction storage is full.");
            return;
        }
        String transactionId = String.valueOf(nextTransactionNumber++);
        transactions[transactionCount] = new Transaction(
                transactionId, amount, type, LocalDate.now().toString(), accountNumber);
        transactionCount++;
    }

    private double readPositiveAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double amount = Double.parseDouble(scanner.nextLine().trim());
                if (amount > 0) {return amount;}
            } catch (NumberFormatException ignored) {}
            System.out.println("Amount must be positive!");
        }
    }

}
