package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P349IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for( int num: nums1){
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<Integer>();
        for( int num: nums2){
            set2.add(num);
        }
        int[] output = new int[set1.size() < set2.size() ? set1.size() : set2.size()];
        int index = 0;
        for(int x: set1){
            if(set2.contains(x)){
                output[index++] = x;
            }
        }

        return Arrays.copyOf(output, index);
    }
}
