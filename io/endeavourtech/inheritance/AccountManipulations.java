package io.endeavourtech.inheritance;

import java.math.BigDecimal;

public class AccountManipulations
{
    public static void main(String[] args) {
        CheckingAccount checkingAccount1 = new CheckingAccount("CHK12345", new BigDecimal("100"));
        checkingAccount1.credit(new BigDecimal("50"));
        checkingAccount1.debit(new BigDecimal("50"));
        System.out.println("Balance in Checking Account 1 after credit and debit is " + checkingAccount1.getAccountBalance());


        SavingsAccount savingsAccount1 = new SavingsAccount("SAV123456", new BigDecimal("100"));
        savingsAccount1.debit(new BigDecimal("50"));
        savingsAccount1.credit(new BigDecimal("50"));
        System.out.println("Balance in Savings Account 1 after credit and debit is " + savingsAccount1.getAccountBalance());


        Account checkingAccount2 = new CheckingAccount("CHK98765", new BigDecimal("250"));
        checkingAccount2.debit(new BigDecimal("75"));
        checkingAccount2.credit(new BigDecimal("55"));
        System.out.println("Balance in Checking Account 2 after credit and debit is " + checkingAccount2.getAccountBalance());


        System.out.println("Is Checking Account 1 an Account? " + (checkingAccount1 instanceof Account));
        System.out.println("Is Savings Account 1 an Account? " +(savingsAccount1 instanceof Account));
        System.out.println("Is Checking Account 2 an Checking Account? " +(checkingAccount2 instanceof CheckingAccount));
        System.out.println("Is Checking Account 2 an Account? " +(checkingAccount2 instanceof Account));

        //The below print statement will fail since inheritance doesn't have a child to child relationship
        //System.out.println("Is savings account 1 a Checking Account" +(savingsAccount1 instanceof CheckingAccount));


        Account[] bankAccountArray = new Account[] {checkingAccount1, savingsAccount1, checkingAccount2};
        System.out.println( "Total Account Balance of the bank to be reported to the regulatory agencies is " + calculateTotalBankBalances(bankAccountArray));

        checkingAccount1.printAccountDetails();
        savingsAccount1.printAccountDetails();
        checkingAccount2.printAccountDetails();
    }


    /**
     * Calculates the total balance of all the accounts in the bank
     * @param inputBankAccountArray - Input array containing all the accounts of the bank.
     * @return
     */
    private static BigDecimal calculateTotalBankBalances (Account[] inputBankAccountArray)
    {
        BigDecimal totalBalance = BigDecimal.ZERO;
        for (Account eachAccount : inputBankAccountArray)
        {
           totalBalance = totalBalance.add(eachAccount.getAccountBalance());
        }
        return totalBalance;
    }
}
