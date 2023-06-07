package io.endeavourtech.inheritance;

import java.math.BigDecimal;

public abstract class Account {
    private String accountNumber;
    private BigDecimal accountBalance;

    public Account(String accountNumber, BigDecimal accountBalance)
    {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    /**
     * This method performs debit transactions on the account
     * @param amountToDebit - The amount to be debited from the account
     */
    public void debit(BigDecimal amountToDebit)
    {
        accountBalance = accountBalance.subtract(amountToDebit);
    }
    /**
     * This method performs credit transactions on the account
     * @param amountToCredit - The amount to be credited from the account
     */
    public void credit(BigDecimal amountToCredit)
    {
        accountBalance = accountBalance.add(amountToCredit);
    }
    public abstract void printAccountDetails();
}

