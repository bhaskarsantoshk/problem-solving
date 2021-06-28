package data_structures.arrays;

import java.util.HashMap;

public class NonRepeatingInteger {
    public static int findFirstUnique(int[] a){
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int num: a){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for ( int i=0; i<a.length; i++){
            if(map.get(a[i]) == 1){
                return a[i];
            }
        }
        return -1;
    }
}
