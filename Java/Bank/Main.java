package Bank;

public class Main {
    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();

        Runnable wd = new Runnable() {
            public void run(){
                sbi.withdraw(50);
            }
        };

        Thread t1 = new Thread(wd,"Thread 1");
        Thread t2 = new Thread(wd,"Thread 2");
        Thread t3 = new Thread(wd,"Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
