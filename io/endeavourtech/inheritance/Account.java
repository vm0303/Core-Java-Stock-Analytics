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

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Account{");
        sb.append("accountNumber='").append(accountNumber).append('\'');
        sb.append(", accountBalance=").append(accountBalance);
        sb.append('}');
        return sb.toString();
    }

    /**
     * This written code  overrides the equal method in Java.lang.Object in order to properly
     * check whether two accounts are same or not.
     * @param otherObj - This variable compares with the "this" keyword to compare and contrast the string values.
     * @return
     */
    @Override
    public boolean equals(Object otherObj) {
        boolean isEqual = false;
        Account otherAccountObj =null;
        if (otherObj instanceof Account && otherObj != null)
        {
            otherAccountObj = (Account) otherObj;
            if (this.accountNumber.equals(otherAccountObj.getAccountNumber()))
            {
                isEqual =true;
            }
        }

        return isEqual;

    }
}

