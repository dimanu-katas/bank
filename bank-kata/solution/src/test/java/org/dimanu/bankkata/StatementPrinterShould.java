package org.dimanu.bankkata;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

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
}