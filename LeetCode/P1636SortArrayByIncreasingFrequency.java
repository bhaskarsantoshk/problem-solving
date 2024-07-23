package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1636SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1 ));
        return Arrays.stream(nums).boxed()
                .sorted((a,b)->map.get(a) != map.get(b) ? map.get(a)-map.get(b) : b-a)
                .mapToInt(n->n)
                .toArray();
    }


    public int[] frequencySort2(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        for ( int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        Integer[] numsObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsObj[i] = nums[i];
        }

        Arrays.sort(numsObj, (a,b)-> (map.get(a) != map.get(b)) ? map.get(a) - map.get(b) : b-a);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsObj[i];
        }

        return nums;
    }
}
