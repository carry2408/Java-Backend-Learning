package Counter;

public class Main {
    public static void main(String[] args) {
        
    Counter ob = new Counter();

    Runnable r = new Runnable() {
        public void run() {
            ob.increment();
        };
    };
    
    Thread t1 = new Thread(r);
    Thread t2 = new Thread(r);
    
    System.out.println(Counter.count);
    t1.start();
    t2.start();
    try {
        t1.join();
        t2.join();
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    System.out.println(Counter.count);
    }

}
