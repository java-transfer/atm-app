package utils;
import utils.AccountData;


public class Functions {

    public float getAccountBalance() {
        System.out.println("Account balance is "+AccountData.accountBalance);
        return AccountData.accountBalance;
    }

    public void debitAccount(float amountToDebit) {
        float newAccountBalance = AccountData.accountBalance - amountToDebit;
        AccountData.accountBalance = newAccountBalance;
        System.out.println("Account debited with "+amountToDebit+"\nNew balance is "+AccountData.accountBalance);
    }

    public void creditAccount(float amountToCredit) {
        float newAccountBalance = AccountData.accountBalance + amountToCredit;
        AccountData.accountBalance = newAccountBalance;
        System.out.println("Account credited with "+amountToCredit+"\nNew balance is "+AccountData.accountBalance);
    }

    public void setAccountType(String accountToSet) {
        AccountData.accountType = accountToSet;
        System.out.println("Account type set to "+AccountData.accountType);
    }
}
