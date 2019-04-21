package LeetCode;

public class P198HouseRobber {
    public int rob(int[] nums) {
        if(nums== null || nums.length==0 || nums.length==1){
            if(nums.length == 1) return nums[0];
            return 0;
        }
        long dp[] = new long[nums.length];
        dp[0] = nums[0];
        long max= dp[0];
        dp[1] = Math.max(max, nums[1]);
        max = Math.max(max, dp[1]);
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            max = Math.max(dp[i], max);
        }
        return (int)max;
    }
}
