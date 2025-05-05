package takeUForward.dynamicProgramming.revision;

public class P6HouseRobber {
    public int houseRobber(int[] money) {
        int [] list1 = new int[money.length-1];
        int [] list2 = new int[money.length-1];
        for ( int i=0; i<money.length-1; i++){
            list1[i] = money[i];
            list2[i] = money[i+1];
        }
        int ans1 = nonAdjacentSpaceOptimization(list1);
        int ans2 = nonAdjacentSpaceOptimization(list2);
        return Math.max(ans1, ans2);
    }

    public int nonAdjacentSpaceOptimization(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 =0;
        for ( int i=1; i<n; i++){
            int nonPick = prev;
            int pick = nums[i];
            if ( i > 1) pick += prev2;
            int cur = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
