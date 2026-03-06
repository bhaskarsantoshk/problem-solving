package company.apple;

import java.util.*;

public class P43IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int num: nums1) map.put(num, map.getOrDefault(num,0)+1);
        List<Integer> intersection = new ArrayList<>();
        for ( int num: nums2){
            if ( map.containsKey(num) && map.get(num) > 0) {
                intersection.add(num);
                map.put(num, map.get(num)-1);
            }
        }
        int res[] = new int[intersection.size()];
        int index = 0;
        for ( int num: intersection) res[index++] = num;
        return res;
    }
}
