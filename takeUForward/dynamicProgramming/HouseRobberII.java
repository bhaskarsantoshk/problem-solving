package takeUForward.dynamicProgramming;

// https://bit.ly/3F6q83P

import java.util.Arrays;

public class HouseRobberII {
    public static long houseRobber(int[] valueInHouse) {
        if ( valueInHouse == null || valueInHouse.length == 0) return 0;
        if ( valueInHouse.length == 1) return valueInHouse[0];
        int arrayExceptFirstHouse [] = new int[valueInHouse.length-1];
        int arrayExceptLastHouse[] = new int[valueInHouse.length-1];
        for ( int i=0;i<valueInHouse.length-1; i++){
            arrayExceptLastHouse[i] = valueInHouse[i];
        }
        for ( int i=1;i<valueInHouse.length; i++){
            arrayExceptFirstHouse[i-1] = valueInHouse[i];
        }

        long ans1 = maxSumOfNonAdjacentElements(arrayExceptFirstHouse);
        long ans2 = maxSumOfNonAdjacentElements(arrayExceptLastHouse);
        return Math.max(ans1, ans2);
    }

    private static long maxSumOfNonAdjacentElements(int[] nums) {
        long [] memo = new long[nums.length];
        Arrays.fill(memo, -1);
        return f(nums, nums.length-1, memo);
    }

    private static long f(int[] nums, int index, long [] memo) {
        if ( index == 0){
            return nums[index];
        }
        if ( index < 0) return 0;
        if ( memo[index] != -1) return memo[index];
        long pick = nums[index] + f(nums, index-2, memo);
        long nonPick = f(nums, index-1, memo);
        return memo[index] = Math.max(pick, nonPick);
    }
}
