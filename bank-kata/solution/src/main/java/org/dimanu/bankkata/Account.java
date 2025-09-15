package org.dimanu.bankkata;

public class Account {

    private final TransactionRepository transactionRepository;
    private final Clock clock;

    public Account(TransactionRepository transactionRepository, Clock clock) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
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