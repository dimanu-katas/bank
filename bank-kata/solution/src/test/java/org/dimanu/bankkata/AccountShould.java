package org.dimanu.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountShould {

    private final int ANY_AMOUNT = 1000;
    private final String ANY_DATE = "10/01/2025";
    private final Transaction DEPOSIT = new Transaction(ANY_AMOUNT, ANY_DATE);
    private final Transaction WITHDRAWAL = new Transaction(-ANY_AMOUNT, ANY_DATE);

    @Mock TransactionRepository transactionRepository;
    @Mock Clock clock;
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(transactionRepository, clock);
    }

    @Test
    void record_a_deposit_transaction() {
        given(clock.todayAsString()).willReturn(ANY_DATE);

        account.deposit(ANY_AMOUNT);

        verify(transactionRepository).record(DEPOSIT);
    }

    @Test
    void record_a_withdrawal_transaction() {
        given(clock.todayAsString()).willReturn(ANY_DATE);

        account.withdraw(ANY_AMOUNT);

        verify(transactionRepository).record(WITHDRAWAL);
    }
}