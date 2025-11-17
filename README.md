# :dollar: Bank Kata :dollar:

These instructions where extracted from Codurance website. You can find the link below:

[![Web](https://img.shields.io/badge/codurance-14a1f0?style=for-the-badge&logo=github&logoColor=white&labelColor=101010)](https://www.codurance.com/katas/bank)

## Description

Implement a simple banking system that allows users to:

- Deposit money into their account.
- Withdraw money from their account.
- Print a statement of their account transactions.

The acceptance criteria is the following:

Statement should have transactions in the following format:

```bash
DATE       | AMOUNT  | BALANCE
14/01/2025 | -500.00 | 2500.00
13/01/2025 | 2000.00 | 3000.00
10/01/2025 | 1000.00 | 1000.00
```

## Restrictions

- Start with a class that has the following interface:
    ```java
    public class Account {
  
        public void deposit(int amount);
  
        public void withdraw(int amount);
  
        public void printStatement();
    }
    ```
- You cannot add any public method to this class
- Don't worry about spacing and formatting the statement in the console
- For simplicity, you can use primitives for amount and dates

## Objective

The objetive is to develop the solution applying Outside-In TDD

## Visit my GitHub profile for more katas 🚀

[![Web](https://img.shields.io/badge/GitHub-Dimanu.py-14a1f0?style=for-the-badge&logo=github&logoColor=white&labelColor=101010)](https://github.com/dimanu-katas/repositories)