package data_structures.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumbers {
    public static int[] getNumbers(int[] a, int sum){
        int res[] = new int[2];
        Set<Integer> set = new HashSet<>();
        for ( int i=0; i<a.length; i++){
            if ( set.contains(sum-a[i])){
                res[0] = a[i];
                res[1] = sum-a[i];
                break;
            } else{
                set.add(a[i]);
            }
        }
        Arrays.sort(res);
        return res;
    }
}
