package company.google.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P215KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for ( int num: nums) list.add(num);
        return quickSelect(list, k);
    }

    private int quickSelect(List<Integer> nums, int k) {
        int pivotIndex = new Random().nextInt(nums.size());
        int pivot = nums.get(pivotIndex);

        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for ( int num: nums){
            if ( num > pivot){
                left.add(num);
            } else if ( num < pivot){
                right.add(num);
            } else {
                mid.add(num);
            }
        }
        if ( k <= left.size()){
            return quickSelect(left, k);
        }
        if ( left.size() + mid.size() < k){
            return quickSelect(right, k-left.size()-mid.size());
        }
        return pivot;
    }
}
