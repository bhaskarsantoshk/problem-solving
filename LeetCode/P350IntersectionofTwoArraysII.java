package LeetCode;

import java.util.*;

public class P35IntersectionOfTwoArraysII {
    public int[] intersectionBruteForce(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums1) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (count.containsKey(num) && count.get(num) > 0) {
                res.add(num);
                count.put(num, count.get(num) - 1);
            }
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if ( nums1[i]==nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i]<nums2[j]){
                i++;
            } else {
                j++;
            }
        }
        return res.stream().mapToInt(k->k).toArray();
    }
}
