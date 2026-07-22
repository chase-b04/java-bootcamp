javac AbstractAccount.java AbstractSavings.java AbstractDemo.javapublic class EncapsulationDemo {
    public static void main(String[] args) {
        Account account = new Account(100.00);
//        account.balance = 999999;
        account.deposit(50.00);     // balance: 150
        account.withdraw(30.00);    // balance: 120
        account.withdraw(500.00);   // rejected; balance remains 120

        System.out.printf(
                "Final balance: %.2f%n", account.getBalance());
    }
//    if (interest != 500.00) {
//        throw new AssertionError(
//                "Expected 500.00, got " + interest);
//    }
}


//Error:
//PS C:\Users\Chase\java-bootcamp\examples\module-03-exercises> javac Account.java EncapsulationDemo.java
//        EncapsulationDemo.java:4: error: balance has private access in Account
//        account.balance = 999999;
//        ^
//        1 error