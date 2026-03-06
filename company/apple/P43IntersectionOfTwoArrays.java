package company.apple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P43IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for ( int num: nums1) set.add(num);
        Set<Integer> intersection = new HashSet<>();
        for ( int num: nums2){
            if ( set.contains(num)) intersection.add(num);
        }
        int res[] = new int[intersection.size()];
        int index = 0;
        for ( int num: intersection) res[index++] = num;
        return res;
    }
}
