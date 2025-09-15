package org.dimanu.bankkata;

public class Account {

    private final TransactionRepository transactionRepository;
    private final Clock clock;
    private final StatementPrinter statementPrinter;

    public Account(TransactionRepository transactionRepository, Clock clock, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount){
        recordTransaction(amount);
    }

    public void withdraw(int amount){
        recordTransaction(-amount);
    }

    public void printStatement(){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void recordTransaction(int amount) {
        String today = clock.todayAsString();
        Transaction transaction = new Transaction(amount, today);
        transactionRepository.store(transaction);
    }

}