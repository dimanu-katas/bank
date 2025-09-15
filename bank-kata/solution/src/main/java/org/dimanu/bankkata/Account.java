package org.dimanu.bankkata;

public class Account {

    private final TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount){
        Transaction depositTransaction = new Transaction(amount);
        transactionRepository.addDeposit(depositTransaction);
    }

    public void withdraw(int amount){
        Transaction withdrawalTransaction = new Transaction(-amount);
        transactionRepository.addWithdrawal(withdrawalTransaction);
    }

    public void printStatement(){
        throw new UnsupportedOperationException("Not implemented yet");
    }
}