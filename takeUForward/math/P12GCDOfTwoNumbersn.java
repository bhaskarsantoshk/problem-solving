package takeUForward.math;

import java.util.*;

public class P12GCDOfTwoNumbersn {
    public int GCD(int n1, int n2) {
        List<Integer> list1= getDivisors(n1);
        List<Integer> list2= getDivisors(n2);
        int max = 0;
        Set<Integer> set = new HashSet<>(list1);
        for ( Integer num: list2){
            if ( set.contains(num)){
                max = Math.max(num, max);
            }
        }
        return max;
    }

    private List<Integer> getDivisors(int num) {
        if ( num == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for ( int i=2; i*i<=num; i++){
            if ( num % i == 0){
                list.add(i);
                if ( i != num/i) list.add(num/i);
            }
        }
        return list;
    }

    public int GCDBruteforce(int n1, int n2) {
        if ( n1 == 0 || n2== 0) return 0;
        int largest = 1;
        for ( int i=2; i<=Math.min(n1,n2); i++){
            if ( n1 % i == 0 && n2%i == 0) largest = i;
        }
        return largest;
    }

    public int GCDBetter(int n1, int n2) {
        if ( n1 == 0 || n2== 0) return 0;
        int largest = 1;
        for ( int i=Math.min(n1,n2); i>=1; i--){
            if ( n1 % i == 0 && n2%i == 0) {
                largest = i;
                break;
            }
        }
        return largest;
    }

    // GCD(x,y) = GCD(x-y,y) if x > y Euclidean algorithm
    public int GCDFaster(int n1, int n2) {
        if ( n1 == 0 || n2== 0) return 0;
        while ( n1 != 0 && n2!= 0){
            if ( n1 > n2) n1 = n1-=n2;
            else n2 = n2-=n1;
        }
        return (n1==0) ? n2: n1;
    }

    public int GCDMostOptimal(int n1, int n2) {
        if ( n1 == 0 || n2== 0) return 0;
        while ( n1 != 0 && n2!= 0){
            if ( n1 > n2) n1 = n1%n2;
            else n2 = n2%n1;
        }
        return (n1==0) ? n2: n1;
    }
}
