import io.endeavourtech.inheritance.Account;
import io.endeavourtech.inheritance.CheckingAccount;
import io.endeavourtech.inheritance.SavingsAccount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GenericsPlayGround {
    public static void main(String[] args) {
        List<Account> checkingAccountList1= new ArrayList<>();
        checkingAccountList1.add(new CheckingAccount("CH12345", new BigDecimal("250")));
        checkingAccountList1.add(new CheckingAccount("CHK675321", new BigDecimal(425)));


        List<Account> savingsAccountList1= new ArrayList<>();
        savingsAccountList1.add(new SavingsAccount("SAV12345", new BigDecimal("375")));
        savingsAccountList1.add(new SavingsAccount("SAV09876", new BigDecimal(1000)));


        // Add another collection
        // Append elements of savingsAccountList1 to thr CheckingAccountList1
        checkingAccountList1.addAll(savingsAccountList1);

        //Calculates the total balance.
        calculateTotalBalance(checkingAccountList1);
        calculateTotalBalance(savingsAccountList1);

        anotherWayToCalculateTotalAccountBalances(checkingAccountList1);
        anotherWayToCalculateTotalAccountBalances(savingsAccountList1);

        List<CheckingAccount> checkingAccountList2 = new ArrayList<>();

        List<SavingsAccount> savingsAccountList2 = new ArrayList<>();

        checkingAccountList2.add(new CheckingAccount("ABC42385895", new BigDecimal(100)));
        checkingAccountList2.add(new CheckingAccount("GHI38749823", new BigDecimal(100)));

        savingsAccountList2.add(new SavingsAccount("SAV92582955", new BigDecimal(100)));
        savingsAccountList2.add(new SavingsAccount("SAV23942093", new BigDecimal(100)));

        //The calling methods below will fail because the method is not using the ? extends method to call the super class.
        //calculateTotalBalance(checkingAccountList2);
        //calculateTotalBalance(savingsAccountList2);

        anotherWayToCalculateTotalAccountBalances(checkingAccountList1);
        anotherWayToCalculateTotalAccountBalances(savingsAccountList2);


    }

    private static void anotherWayToCalculateTotalAccountBalances(List<? extends Account> accountList) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Account eachAccount : accountList) {
            sum = sum.add(eachAccount.getAccountBalance());
        }
        System.out.println("Account balance total using the ? extends method: " + sum);
    }

    private static void calculateTotalBalance(List<Account> accountList)
    {
        BigDecimal sum = BigDecimal.ZERO;
        for (Account eachAccount : accountList) {
            sum = sum.add(eachAccount.getAccountBalance());
        }
        System.out.println("Account balance total: " + sum);
    }


}
