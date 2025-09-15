package org.dimanu.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountShould {

    private final int ANY_AMOUNT = 1000;

    @Mock TransactionRepository transactionRepository;
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(transactionRepository);
    }

    @Test
    void record_a_deposit_transaction() {
        Transaction transaction = new Transaction(ANY_AMOUNT);

        account.deposit(ANY_AMOUNT);

        verify(transactionRepository).addDeposit(transaction);
    }
}