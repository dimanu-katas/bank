package feature;

import org.dimanu.bankkata.Account;
import org.dimanu.bankkata.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PrintStatementFeature {

    @Mock
    Console console;
    private Account account;

    @BeforeEach
    void setup() {
        account = new Account();
    }

    @Test
    void print_statement_with_all_transactions() {
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        account.printStatement();

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("14/01/2025 | -500.00 | 2500.00");
        inOrder.verify(console).printLine("13/01/2025 | 2000.00 | 3000.00");
        inOrder.verify(console).printLine("10/01/2025 | 1000.00 | 1000.00");
    }
}
