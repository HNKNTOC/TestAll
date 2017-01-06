package my.test;

import java.util.concurrent.TimeUnit;

/**
 * TODO: Add doc
 * Created by Nikita on 03.01.2017.
 */
public class Operations {
    public static void main(String[] args) throws InsufficientFundsException, InterruptedException {
        final Account acc1 = new Account(20, "acc1");
        final Account acc2 = new Account(15, "acc2");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(acc1, acc2, 5);
                } catch (InsufficientFundsException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        transfer(acc2, acc1, 10);

        thread.join(1);
        System.out.println(acc1);
        System.out.println(acc2);
    }

    private static void transfer(Account acc1, Account acc2, int amount) throws InsufficientFundsException, InterruptedException {
        System.out.println("Transfer start.");
        if (acc1.getBalance() < amount) throw new InsufficientFundsException();

        if (acc1.getLock().tryLock(1, TimeUnit.SECONDS)) {
            System.out.println("Lock "+acc1.getName());
            Thread.sleep(100);
            try {
                if (acc2.getLock().tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println("Lock "+acc2.getName());
                    try {
                        acc1.withdraw(amount);
                        acc2.deposit(amount);
                    } finally {
                        acc2.getLock().unlock();
                        System.out.println("Unlock "+acc2.getName());
                    }
                }else {
                    System.out.println("Failed lock "+acc2.getName());
                    acc2.incFailedTransferCount();
                }
            } finally {
                acc1.getLock().unlock();
                System.out.println("Unlock "+acc1.getName());
            }
        }else {
            System.out.println("Failed lock "+acc1.getName());
            acc1.incFailedTransferCount();
        }
        System.out.println("Transfer stop.");
    }
}
