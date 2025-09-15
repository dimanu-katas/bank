package org.dimanu.bankkata;

public class Account {

    private final TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
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
        Transaction transaction = new Transaction(amount);
        transactionRepository.record(transaction);
    }

}