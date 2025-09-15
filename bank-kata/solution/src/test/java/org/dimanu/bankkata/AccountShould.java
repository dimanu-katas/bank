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
        Transaction transaction = new Transaction();
        Account account = new Account(transactionRepository);

        account.deposit(1000);

        verify(transactionRepository).addDeposit(transaction);
    }
}