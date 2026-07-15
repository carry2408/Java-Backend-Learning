package Counter;

public class Counter {
   static int count =0;

    public synchronized void increment(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }
}
