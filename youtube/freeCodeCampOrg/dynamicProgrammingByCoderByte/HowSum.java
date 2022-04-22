package youtube.freeCodeCampOrg.dynamicProgrammingByCoderByte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Utility.Utility.print;


public class HowSum {

    // T= O(N^M * M) S= O(M)
    public static ArrayList<Integer> howSumRec (int targetSum, int[] nums){
        if ( targetSum == 0) return new ArrayList<>();
        if ( targetSum < 0) return null;
        for ( int num: nums){
            ArrayList<Integer> remainingResult = howSumRec(targetSum-num, nums);
            if ( remainingResult != null ){
                remainingResult.add(num);
                return remainingResult;
            }
        }
        return null;
    }


    public static ArrayList<Integer> howSumMemoized (int targetSum, int[] nums, Map<Integer, ArrayList> memo){
        if ( memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if ( targetSum == 0) return new ArrayList<>();
        if ( targetSum < 0) return null;
        for ( int num: nums){
            ArrayList<Integer> remainingResult = howSumMemoized(targetSum-num, nums, memo);
            if ( remainingResult != null ){
                remainingResult.add(num);
                memo.put(targetSum, remainingResult);
                return memo.get(targetSum);
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    public static ArrayList<Integer> howSum(int targetSum, int[] nums){
        Map<Integer, ArrayList> memo = new HashMap<>();
        return howSumMemoized(targetSum, nums, memo);
    }

    public static void main(String[] args) {
        print(howSumRec(7, new int[]{2, 3}));
        print(howSumRec(7, new int[]{5, 3, 4, 7}));
        print(howSumRec(7, new int[]{2, 4}));
        print(howSumRec(8, new int[]{2, 3, 5}));
        print(howSumRec(300, new int[]{7, 14}));


        print(howSum(7, new int[]{2, 3}));
        print(howSum(7, new int[]{5, 3, 4, 7}));
        print(howSum(7, new int[]{2, 4}));
        print(howSum(8, new int[]{2, 3, 5}));
        print(howSum(300, new int[]{7, 14}));
    }
}
