package io.endeavourtech.inheritance;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, BigDecimal accountBalance) {
        super(accountNumber, accountBalance);
    }

    @Override
    public void printAccountDetails() {
        System.out.println("Account Number: " + getAccountNumber() + ", Account Balance:" +getAccountBalance());
    }
}
