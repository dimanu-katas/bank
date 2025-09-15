package org.dimanu.bankkata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {

    private final List<Transaction> transactions = new ArrayList<>();

    public void record(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
