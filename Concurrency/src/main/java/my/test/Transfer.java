package my.test;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * TODO: Add doc
 * Created by Nikita on 07.01.2017.
 */
public class Transfer implements Callable<Boolean> {

    private final Account acc1;
    private final Account acc2;
    private final int amount;

    public Transfer(Account acc1, Account acc2, int amount) {
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("Transfer start.");

        if (acc1.getLock().tryLock(1, TimeUnit.SECONDS)) {
            Thread.sleep(new Random().nextInt(3)*100);
            System.out.println("Lock "+acc1.getName());
            try {
                if (acc1.getBalance() < amount)
                    throw new InsufficientFundsException();

                if (acc2.getLock().tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println("Lock "+acc2.getName());
                    try {
                        acc1.withdraw(amount);
                        Thread.sleep(new Random().nextInt(5)*100);
                        acc2.deposit(amount);
                    } finally {
                        acc2.getLock().unlock();
                        System.out.println("Unlock "+acc2.getName());
                    }
                }else {
                    System.out.println("Failed lock "+acc2.getName());
                    acc2.incFailedTransferCount();
                    return false;
                }
            } finally {
                acc1.getLock().unlock();
                System.out.println("Unlock "+acc1.getName());
            }
        }else {
            System.out.println("Failed lock "+acc1.getName());
            acc1.incFailedTransferCount();
            return false;
        }
        System.out.println("Transfer stop.");
        return true;
    }
}
