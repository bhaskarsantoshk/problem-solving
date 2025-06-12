package takeUForward.dynamicProgramming.revision2.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P1LongestIncreasingSubsequence {
    public int LIS(int[] nums) {
        return f(0, -1, nums); // length of LIS starting from 0 with no previous index
        // f(3,0, nums) - means length of LIS starting from 3 with 0 as previous index
    }

    private int f(int index, int prevIndex, int[] nums) {
        if ( index == nums.length) return 0;
        int notTake = f( index+1, prevIndex, nums);
        int take = 0;
        if (prevIndex == -1 || nums[prevIndex] > nums[index]) take = 1+ f(index+1, index, nums);
        return Math.max(take, notTake);
    }

    public int LISMemoized(int[] nums) {
        int n = nums.length;
        int [][] dp = new int[n][n+1];
        for ( int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(0, -1, nums, dp); // length of LIS starting from 0 with no previous index
        // f(3,0, nums) - means length of LIS starting from 3 with 0 as previous index
    }

    private int f(int index, int prevIndex, int[] nums, int[][] dp) {
        if ( index == nums.length) return 0;
        if ( dp[index][prevIndex+1] != -1) return dp[index][prevIndex+1];
        int notTake = f( index+1, prevIndex, nums, dp);
        int take = 0;
        if (prevIndex == -1 || nums[prevIndex] > nums[index]) take = 1+ f(index+1, index, nums, dp);
        return dp[index][prevIndex+1]= Math.max(take, notTake);
    }

    public int LISBinarySearch(int[] nums) {
        int n = nums.length;
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);
        for ( int i=1; i<n; i++){
            if ( nums[i] > lis.get(lis.size()-1)) lis.add(nums[i]);
            else {
                int lowerBound = lowerBound(lis, nums[i]);
                if ( lowerBound < 0) lowerBound= -(lowerBound+1);
                lis.set(lowerBound, nums[i]);
            }
        }
        return lis.size();
    }

    private int lowerBound(List<Integer> list, int key){
        int ans = list.size();
        int low = 0, high = ans-1;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( list.get(mid) >= key){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }


}
