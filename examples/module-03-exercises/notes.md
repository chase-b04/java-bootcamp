# Banking domain notes

| Entity | Identity | Important attributes | Main responsibility |
| ------ | -------- | -------------------- | ------------------- |
| Customer | customerId | name, email, phone | Maintain customer profile |
| Account | accountNumber | owner, balance, accountType | Protect balance and perform deposits/withdrawals |
| Transaction | transactionId | account, type, amount, timestamp | Record one account operation |

## Relationships

- One Customer can own zero or more Accounts.
- One Account belongs to exactly one Customer.
- One Account can have many Transactions.
- One Transaction belongs to exactly one Account.

## Rules

- An account balance cannot be changed directly from outside Account.
- A deposit amount must be positive.
- A withdrawal cannot exceed the allowed balance.


Why: Being able to justify ownership matters more than merely listing nouns.

Answer in 2–3 sentences: Ownership is critical in a banking environment as these services and applications handle 
critical finance or both individuals and coroporations. Account owns the balance and its rules, while Main should only 
coordinate user interaction. Not only does this approach protect users from mixed up accounts and finances, it uses 
OOP principles to secure these accounts.


## SRP spot-check

The original method could change because the formula changes or because
the output format changes. These are separate responsibilities.

Main should manage menu input, BankService should coordinate banking operations, and domain classes should protect their own state.




Write the four principle notes

Why: SOLID only helps if you can justify the design in plain English.
OCP: Software entities should be open for extension, but closed for modification.
LSP: Objects of a superclass should be replaceable with objects of its subclasses without breaking correctness.
ISP: Clients should not be forced to depend on interfaces they do not use.
DIP: High-level modules should not depend on low-level modules. Both should depend on abstractions.

Write all 5 letters from memory:
Why: Lab 3 asks you to review SOLID against the banking design.

Write: Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion.