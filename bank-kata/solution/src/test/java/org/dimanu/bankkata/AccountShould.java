package org.dimanu.bankkata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountShould {

    @Mock TransactionRepository transactionRepository;

    @Test
    void record_a_deposit_transaction() {
        int amount = 1000;
        Transaction transaction = new Transaction(amount);
        Account account = new Account(transactionRepository);

        account.deposit(amount);

        verify(transactionRepository).addDeposit(transaction);
    }
}