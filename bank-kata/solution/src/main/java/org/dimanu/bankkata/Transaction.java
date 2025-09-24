package org.dimanu.bankkata;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Transaction {
    private final int amount;
    private final String date;

    private final DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public Transaction(int amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public void printTo(Console console, int runningBalance) {
        StringBuilder builder = new StringBuilder();
        builder.append(date);
        builder.append(" | ");
        builder.append(decimalFormat.format(amount));
        builder.append(" | ");
        builder.append(decimalFormat.format(runningBalance));
        console.printLine(builder.toString());
    }

    public int calculatePreviousBalance(int currentBalance) {
        return currentBalance - amount;
    }

    public int applyToBalance(int currentBalance) {
        return currentBalance + amount;
    }

    public boolean isMoreRecentThan(Transaction other) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate thisDate = LocalDate.parse(this.date, formatter);
        LocalDate otherDate = LocalDate.parse(other.date, formatter);
        return thisDate.isAfter(otherDate);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, date);
    }
}
