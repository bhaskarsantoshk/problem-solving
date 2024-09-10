package company.google;

import java.util.TreeMap;

public class P1296DivideArrayInSetsOfKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for ( int num: nums) treeMap.put(num, treeMap.getOrDefault(num, 0)+1);
        while (!treeMap.isEmpty()){
            int num = treeMap.firstKey();
            for ( int i= num; i<num+k; i++){
                if ( !treeMap.containsKey(i)) return false;
                else {
                    treeMap.put(i, treeMap.get(i)-1);
                    if ( treeMap.get(i) == 0) treeMap.remove(i);
                }
            }
        }
        return true;
    }
}
