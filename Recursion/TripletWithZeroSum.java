package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithZeroSum {
    public static List<List<Integer>> getTriplets(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for ( int i=0; i<nums.length-2; i++){
            if (i>0 && nums[i] == nums[i-1]) continue;
            getPair(nums, -nums[i], i+1, triplets);
        }
        return triplets;
    }

    private static void getPair(int[] nums, int targetSum, int start, List<List<Integer>> triplets) {
        int end = nums.length-1;

        while ( start < end ){
            int currentSum = nums[start] + nums[end];
            if ( currentSum == targetSum){
                triplets.add(Arrays.asList(-targetSum, nums[start], nums[end]));
                start++;
                end--;
                while ( start < end && nums[start] == nums[start-1]) {
                    start++;
                }
                while ( start < end && nums[end] == nums[end+1]) {
                    end--;
                }
            }
            else if ( currentSum > targetSum ){
                end--;
            }
            else{
                start++;
            }
        }
    }
}
