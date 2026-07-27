package com.academy.bank;

public class SavingsAccount extends Account implements Printable {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, Customer customer, double interestRate) {
        super(accountNumber, balance, customer);   // call Account constructor
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100.0;
    }

    @Override
    public void displayAccount() {
        String type = getAccountType();
        String num = getAccountNumber();
        String name = getCustomer().getName();
        double balance = getBalance();
        double interest = calculateInterest();
        System.out.printf(
                "%s Account%n" +
                        "Account Number : %s%n " +
                        "Customer : %s%n" +
                        "Balance : %.2f%n" +
                        "Interest Rate: %.2f%n" +
                        "Interest: %.2f%n", type, num, name, balance, interestRate, interest);
    }

    @Override
    public void printDetails() {
        displayAccount();
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}
