package company.microsoft;

/*
Problem

Given an integer array nums of length n, find the maximum value of:

(j-i)* |nums[i]-nums[j]|

for all pairs i < j < n.
 */

public class MaximumDistanceValueProduct {
    public int maxValueBruteForce(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for ( int i=0; i<n; i++){
            for ( int j=i+1; j<n; j++){
                ans = Math.max((j-i) * Math.abs(nums[i]-nums[j]), ans);
            }
        }
        return ans;
    }
}
