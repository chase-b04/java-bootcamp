package com.academy.bank;

public class CurrentAccount extends Account implements Printable {
    private double transactionFee;
    public CurrentAccount(String accountNumber, double balance, Customer customer, double transactionFee) {
        super(accountNumber, balance, customer);   // call Account constructor
        this.transactionFee = transactionFee;
    }

    @Override
    public double calculateCharges() {
        return transactionFee;
    }

    @Override
    public void displayAccount() {
        String type = getAccountType();
        String num = getAccountNumber();
        String name = getCustomer().getName();
        double balance = getBalance();
        System.out.printf(
                "%s Account%n" +
                        "Account Number : %s%n" +
                        "Customer : %s%n" +
                        "Balance : %.2f%n" +
                        "Charges: %.2f%n", type, num, name, balance, transactionFee);
    }

    @Override
    public void printDetails() {
        displayAccount();
    }

    @Override
    public String getAccountType() {
        return "Current";
    }
}