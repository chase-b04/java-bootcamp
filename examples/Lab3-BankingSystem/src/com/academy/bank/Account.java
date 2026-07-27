package com.academy.bank;

public abstract class Account {
    // Hidden state: outside code cannot write account.balance directly
    private double balance;
    private String accountNumber;
    private Customer customer;

    protected Account(String initialNumber, double initialBalance, Customer initialCustomer) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative");
        }
        // Account a = new Account("X", 0, someCustomer); // must NOT compile
        balance = initialBalance;
        accountNumber = initialNumber;
        customer = initialCustomer;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println(
                    "Deposit rejected: amount must be positive.");
            return;
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        double withdrawl = amount + calculateCharges();
        if (amount <= 0 || withdrawl > balance) {
            System.out.println("Withdrawal rejected.");
            return false;
        }
        balance -= withdrawl;
        return true;
    }

//    void displayAccount() {
//        String name = customer.getName();
//        System.out.printf(
//                "Account %s: %s, %.2f%n", accountNumber, name, balance);
//    }

    public abstract void displayAccount();

    // Read-only access: callers can inspect, but not assign, the balance
    public double getBalance() {
        return balance;
    }
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public Customer getCustomer() {
        return customer;
    }

    public double calculateCharges() {
        return 0.0;
    }
    public double calculateInterest() {
        return 0.0;
    }

    // Exercise 3 will override this method
    public String getAccountType() {
        return "Account";
    }
}