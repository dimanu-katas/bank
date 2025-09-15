package org.dimanu.bankkata;

public class Account {

    private final TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void withdraw(int amount){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void printStatement(){
        throw new UnsupportedOperationException("Not implemented yet");
    }
}