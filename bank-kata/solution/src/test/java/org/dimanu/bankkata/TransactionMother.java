package org.dimanu.bankkata;

public class TransactionMother {

    public static Transaction deposit(int amount, String date) {
        return new Transaction(amount, date);
    }

    public static Transaction withdrawal(int amount, String date) {
        return new Transaction(-amount, date);
    }

    public static Transaction any() {
        return new Transaction(1000, "01/10/2025");
    }
}
