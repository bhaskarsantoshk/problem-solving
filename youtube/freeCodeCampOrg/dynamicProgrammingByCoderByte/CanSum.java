package youtube.freeCodeCampOrg.dynamicProgrammingByCoderByte;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

public class CanSum {

    // T = O (N^Target Sun), S= O(M)
    public static boolean canSumRec (int targetSum, int[] nums){
        if ( targetSum == 0) return true;
        if ( targetSum < 0) return false;
        for ( int num: nums){
            if ( canSumRec(targetSum-num, nums) == true){
                return true;
            }
        }
        return false;
    }


    public static boolean canSum( int targetSum, int[] nums){
        Map<Integer, Boolean> memo = new HashMap<>();
        return canSumMemoized(targetSum, nums, memo);
    }

    private static boolean canSumMemoized(int targetSum, int[] nums, Map<Integer, Boolean> memo) {
        if ( memo.containsKey(targetSum)){
            return memo.get(targetSum);
        }
        if ( targetSum == 0) return true;
        if ( targetSum < 0) return false;
        for ( int num: nums){
           if ( canSumMemoized(targetSum-num, nums, memo) == true){
               memo.put(targetSum, true);
               return true;
           }
        }
        memo.put(targetSum, false);
        return false;
    }


    public static void main(String[] args){
        System.out.println(canSumRec(7, new int[]{2, 3}));
        System.out.println(canSumRec(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSumRec(7, new int[]{2, 4}));
        System.out.println(canSumRec(8, new int[]{2, 3, 5}));
        System.out.println(canSumRec(300, new int[]{7, 14}));

        System.out.println(canSum(7, new int[]{2, 3}));
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSum(7, new int[]{2, 4}));
        System.out.println(canSum(8, new int[]{2, 3, 5}));
        System.out.println(canSum(300, new int[]{7, 14}));
    }
}
