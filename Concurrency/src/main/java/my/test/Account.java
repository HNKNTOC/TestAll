package my.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Performs operation with balance.
 */
public class Account{
    private int balance;
    private Lock lock = new ReentrantLock();
    private final String name;
    private AtomicInteger failedCounter = new AtomicInteger();

    public Account(int initBalance, String name){
        this.balance = initBalance;
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount){
        System.out.println(name+": -"+amount);
        balance-=amount;
    }

    public void deposit(int amount){
        System.out.println(name+": +"+amount);
        balance+=amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", name='" + name + '\'' +
                ", failedCounter=" + failedCounter +
                '}';
    }

    public Lock getLock() {
        return lock;
    }

    public void incFailedTransferCount() {
        failedCounter.incrementAndGet();
    }

    public String getName() {
        return name;
    }
}
