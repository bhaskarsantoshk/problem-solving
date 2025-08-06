package takeUForward.dynamicProgramming.revision3;

public class P5HouseRobber {
    public int houseRobber(int[] money) {
        int n = money.length;
        int [] list1 = new int[n-1];
        int [] list2 = new int[n-1];
        for ( int i=1; i<n; i++){
            list1[i-1] = money[i-1];
            list2[i-1] = money[i];
        }

        return Math.max(nonAdjacentDP(list1), nonAdjacentDP(list2));
    }

    public int nonAdjacentDP(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        dp[0] = nums[0];
        for ( int i=1; i<n; i++){
            int pick = nums[i];
            if ( i >=2 ) pick += dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n-1];
    }
}
