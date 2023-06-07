package io.endeavourtech.inheritance;

import java.math.BigDecimal;

public class CheckingAccount extends Account
{
   final static double cashBackRate = 2.0;
    public CheckingAccount(String accountNumber, BigDecimal accountBalance) {
        super(accountNumber, accountBalance);
    }

    public void debit(BigDecimal amountToDebit)
    {
        BigDecimal cashBackAmount =  amountToDebit
                .multiply(new BigDecimal(cashBackRate))
                .divide(new BigDecimal("100"));
                super.debit(amountToDebit);
                super.credit(cashBackAmount);
    }

    @Override
    public void printAccountDetails() {
        System.out.println("Account Number: " + getAccountNumber() + ", Account Balance: " + getAccountBalance()+ ", Cash Back Rate: " + cashBackRate );
    }
}
