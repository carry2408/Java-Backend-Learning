package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Collection<Integer> list = new ArrayList<>();

        Random ran = new Random();
        for (int i = 1; i <=5; i++) {
            list.add(ran.nextInt(100));
        }
        Comparator<Integer> com = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
               if (o1%10>=o2%10) {
                return 1;
               }
               else{
                return -1;
               }
            }
            
        };
        list.stream().sorted(com).forEach(n->System.out.println(n));
        


    }
}
