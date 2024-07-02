package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return resArr.clone();
    }
}
