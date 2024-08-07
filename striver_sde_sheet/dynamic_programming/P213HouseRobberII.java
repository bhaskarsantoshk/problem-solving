package striver_sde_sheet.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P213HouseRobberII {
    public int rob(int[] nums) {
        if ( nums == null || nums.length == 0) return 0;
        if ( nums.length == 1) return nums[0];
        List<Integer> listExceptFirst = new ArrayList<>();
        List<Integer> listExceptLast = new ArrayList<>();
        for ( int i=0; i< nums.length; i++){
            if ( i != 0) listExceptFirst.add(nums[i]);
            if ( i != nums.length-1) listExceptLast.add(nums[i]);
        }
        int ans1 = maximumNonAdjacentSumTabularSpaceOptimization((ArrayList<Integer>) listExceptFirst);
        int ans2 = maximumNonAdjacentSumTabularSpaceOptimization((ArrayList<Integer>) listExceptLast);
        return Math.max(ans1, ans2);

    }


    // Solution from prev problem
    public static int maximumNonAdjacentSumTabularSpaceOptimization(ArrayList<Integer> nums) {
        if ( nums == null || nums.size() == 0) return 0;
        if ( nums.size() == 1) return nums.get(0);
        int ans , prev , prev2;
        ans = 0;
        prev = prev2 = nums.get(0);
        for ( int i=1; i<nums.size(); i++){
            int pick = nums.get(i);
            if ( i > 1) pick += prev2;
            int notPick = prev;
            ans = Math.max(pick, notPick);
            prev2 = prev;
            prev = ans;
        }
        return ans;
    }
}
