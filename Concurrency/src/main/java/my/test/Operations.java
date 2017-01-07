package my.test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * TODO: Add doc
 * Created by Nikita on 03.01.2017.
 */
public class Operations {
    public static void main(String[] args) throws InsufficientFundsException, InterruptedException {
        final Account acc1 = new Account(100, "acc1");
        final Account acc2 = new Account(0, "acc2");

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("=====INFORMATION=====");
                System.out.println(acc1);
                System.out.println(acc2);
                System.out.println("====================");
            }
        };

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        service.schedule(runnable,1,TimeUnit.SECONDS);

        for (int i = 0; i < 10; i++) {
            service.submit(
                    new Transfer(acc1,acc2,10)
            );
        }

        service.shutdown();

        service.awaitTermination(5,TimeUnit.SECONDS);

        System.out.println(acc1);
        System.out.println(acc2);
    }
}
