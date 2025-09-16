package org.dimanu.bankkata;

import java.text.DecimalFormat;
import java.util.Objects;

public class Transaction {
    private final int amount;
    private final String date;

    private final DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public Transaction(int amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public void printTo(Console console) {
        StringBuilder builder = new StringBuilder();
        builder.append(date);
        builder.append(" | ");
        builder.append(decimalFormat.format(amount));
        builder.append(" | ");
        builder.append(decimalFormat.format(amount));
        console.printLine(builder.toString());
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
