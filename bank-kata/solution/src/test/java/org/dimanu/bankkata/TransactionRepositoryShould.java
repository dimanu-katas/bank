package org.dimanu.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionRepositoryShould {

    private TransactionRepository transactionRepository;

    @BeforeEach
    void setup() {
        transactionRepository = new TransactionRepository();
    }

    @Test
    void record_and_retrieve_transaction() {
        Transaction transaction = new Transaction(1000, "10/01/2025");

        transactionRepository.record(transaction);
        List<Transaction> recorded_transactions = transactionRepository.getAllTransactions();

        assertThat(recorded_transactions).containsExactly(transaction);
    }
}