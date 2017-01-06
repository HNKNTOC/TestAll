package my.test;

import java.util.concurrent.TimeUnit;

/**
 * TODO: Add doc
 * Created by Nikita on 03.01.2017.
 */
public class Operations {
    public static void main(String[] args) throws InsufficientFundsException, InterruptedException {
        final Account a = new Account(10, "acc1");
        final Account b = new Account(5, "acc2");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(a,b,2);
                } catch (InsufficientFundsException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        transfer(b,a,1);

        System.out.println(a);
        System.out.println(b);
    }

    private static void transfer(Account acc1, Account acc2, int amount) throws InsufficientFundsException, InterruptedException {
        System.out.println("Transfer start.");
        if(acc1.getBalance() < amount) throw new InsufficientFundsException();

            if(acc1.getLock().tryLock(1, TimeUnit.SECONDS)){
                try {
                    if(acc2.getLock().tryLock(1, TimeUnit.SECONDS)){
                        try {
                            acc1.withdraw(amount);
                            acc2.deposit(amount);
                        } finally {
                            acc2.getLock().unlock();
                        }
                    }
                }finally {
                    acc1.getLock().unlock();
                }
            }
        System.out.println("Transfer stop.");
    }
}
