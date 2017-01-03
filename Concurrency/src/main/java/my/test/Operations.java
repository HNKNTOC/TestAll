package my.test;

/**
 * TODO: Add doc
 * Created by Nikita on 03.01.2017.
 */
public class Operations {
    public static void main(String[] args) throws InsufficientFundsException {
        final Account a = new Account(1000);
        final Account b = new Account(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(a,b,500);
                } catch (InsufficientFundsException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        transfer(a,b,300);

        System.out.println(a);
        System.out.println(b);
    }

    private static void transfer(Account acc1, Account acc2, int amount) throws InsufficientFundsException {
        System.out.println("Transfer start.");
        if(acc1.getBalance() < amount) throw new InsufficientFundsException();

        acc1.deposit(amount);
        acc2.withdraw(amount);
        System.out.println("Transfer stop.");
    }
}
