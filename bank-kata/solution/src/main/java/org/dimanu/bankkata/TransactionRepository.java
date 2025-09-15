package org.dimanu.bankkata;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    private List<Transaction> transactions = new ArrayList<>();

    public void record(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getAllTransactions() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
