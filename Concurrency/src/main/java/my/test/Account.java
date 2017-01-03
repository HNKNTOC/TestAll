package my.test;

/**
 * TODO: Add doc
 * Created by Nikita on 03.01.2017.
 */
public class Account {
    private int balance;

    public Account(int initBalance){
        this.balance = initBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount){
        balance-=amount;
    }

    public void deposit(int amount){
        balance+=amount;
    }

    @Override
    public String toString() {
        return "my.test.Account{" +
                "balance=" + balance +
                '}';
    }
}
