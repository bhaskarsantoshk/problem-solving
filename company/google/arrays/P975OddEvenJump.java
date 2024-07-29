package company.google.arrays;

import java.util.Map;
import java.util.TreeMap;

public class P975OddEvenJump {
    public int oddEvenJumps(int[] arr) {
        int goodStartingIndex = 1;
        int n = arr.length;
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];
        higher[n-1] = lower[n-1] = true;

        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(arr[n-1], n-1);

        for ( int i=n-2; i>=0; i--){
            Map.Entry<Integer, Integer> high = map.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> low = map.floorEntry(arr[i]);
            if ( high != null ){
                higher[i] = lower[(int)high.getValue()];
            }
            if ( low != null ){
                lower[i] = higher[(int)low.getValue()];
            }
            if ( higher[i] == true) goodStartingIndex++;
            map.put(arr[i], i);
        }
        return goodStartingIndex;
    }
}
