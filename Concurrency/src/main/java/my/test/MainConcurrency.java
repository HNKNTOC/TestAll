package my.test;

class MainConcurrency {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("=========");
            go();
        }
    }

    private static void go() throws InterruptedException {
        Balance balance = new Balance();

        for (int i = 0; i < 100; i++) {
            goThread2(balance);
            goThread1(balance);
        }

        Thread.sleep(10 * 100);




        System.out.println("Balance: " + balance.getBalance());
    }

    private static void goThread2(final Balance balance) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //System.out.println("runnable1");
                balance.inc();
            }
        });
        thread1.start();
    }

    private static void goThread1(final Balance balance) {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //System.out.println("runnable2");
                balance.dec();
            }
        });
        thread2.start();
    }

    static class Balance {
        private int balance;

        public void inc() {
            balance++;
        }

        public void dec() {
            balance--;
        }

        public int getBalance() {
            return balance;
        }
    }

}