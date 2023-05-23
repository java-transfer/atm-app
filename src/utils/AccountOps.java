package utils;

public class AccountOps {
    float accountBalance = 100000f;
    String accountType = "Savings";
    int PIN = 5555;

    public float getAccountBalance() {
        return accountBalance;
    }

    public void debitAccount(float amountToDebit) {
        float newAccountBalance = accountBalance - amountToDebit;
        accountBalance = newAccountBalance;
    }

    public void creditAccount(float amountToCredit) {
        float newAccountBalance = accountBalance - amountToCredit;
        accountBalance = newAccountBalance;
    }

}
