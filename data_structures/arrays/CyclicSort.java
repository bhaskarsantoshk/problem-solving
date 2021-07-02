package data_structures.arrays;

import static Recursion.DataFormatter.swap;

public class CyclicSort {
    public static void cyclicSort(int[] nums) {
        int index = 0;
        while ( index < nums.length ){
            //  1 should be at index 0, 2 should be index 1 , and so on..
            if ( nums[index] != nums[nums[index]-1]){
                swap(nums, index, nums[index]-1);
            }
            else {
                index++;
            }
        }
    }
}
