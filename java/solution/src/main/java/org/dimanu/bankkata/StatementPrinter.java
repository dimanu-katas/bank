package org.dimanu.bankkata;

import java.util.List;

public class StatementPrinter {
    public static final String HEADER = "DATE | AMOUNT | BALANCE";

    private Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printLine(HEADER);
        List<Transaction> orderedTransactions = orderTransactionsByMostRecentFirst(transactions);

        int runningBalance = calculateFinalBalance(transactions);

        for (Transaction transaction : orderedTransactions) {
            transaction.printTo(console, runningBalance);
            runningBalance = transaction.calculatePreviousBalance(runningBalance);
        }
    }

    private int calculateFinalBalance(List<Transaction> transactions) {
        int balance = 0;
        for (Transaction transaction : transactions) {
            balance = transaction.applyToBalance(balance);
        }
        return balance;
    }

    private List<Transaction> orderTransactionsByMostRecentFirst(List<Transaction> transactions) {
        return transactions.stream()
                .sorted(this::compareByDateMostRecentFirst)
                .toList();
    }

    private int compareByDateMostRecentFirst(Transaction t1, Transaction t2) {
        return Boolean.compare(t2.isMoreRecentThan(t1), t1.isMoreRecentThan(t2));
    }
}
