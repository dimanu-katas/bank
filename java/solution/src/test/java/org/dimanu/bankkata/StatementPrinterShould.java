package org.dimanu.bankkata;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StatementPrinterShould {
    private final List<Transaction> NO_TRANSACTIONS = Collections.emptyList();
    private final String HEADER = "DATE | AMOUNT | BALANCE";

    @Mock Console console;
    private StatementPrinter statementPrinter;

    @BeforeEach
    void setUp() {
        statementPrinter = new StatementPrinter(console);
    }

    @Test
    void only_print_header_when_no_transactions() {
        statementPrinter.print(NO_TRANSACTIONS);

        verify(console).printLine(HEADER);
    }

    @Test
    void print_statemen_with_only_one_transaction() {
        List<Transaction> transactions = List.of(
                TransactionMother.deposit(1000, "10/01/2025")
        );

        statementPrinter.print(transactions);

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine(HEADER);
        inOrder.verify(console).printLine("10/01/2025 | 1000.00 | 1000.00");
    }

    @Test
    void print_statement_with_multiple_transactions_in_chronological_reversed_order() {
        List<Transaction> transactions = List.of(
                TransactionMother.deposit(1000, "10/01/2025"),
                TransactionMother.deposit(2000, "13/01/2025"),
                TransactionMother.withdrawal(500, "14/01/2025")
        );

        statementPrinter.print(transactions);

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine(HEADER);
        inOrder.verify(console).printLine("14/01/2025 | -500.00 | 2500.00");
        inOrder.verify(console).printLine("13/01/2025 | 2000.00 | 3000.00");
        inOrder.verify(console).printLine("10/01/2025 | 1000.00 | 1000.00");
    }
}