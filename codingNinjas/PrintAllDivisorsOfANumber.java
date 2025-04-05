package codingNinjas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintAllDivisorsOfANumber {
    public static List< Integer > printDivisors(int n) {
       List<Integer> list = new ArrayList<>();
       for ( int i=1; i<=Math.sqrt(n); i++){
           if ( n % i == 0){
               list.add(i);
               if ( n/i != i){
                   list.add(n/i);
               }
           }
       }
       Collections.sort(list);
       return list;
    }
}
