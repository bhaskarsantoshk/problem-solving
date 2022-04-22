package youtube.freeCodeCampOrg.dynamicProgrammingByCoderByte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Utility.Utility.print;

public class BestSum {
    public static void main(String[] args){
        print(bestSumRec(7, new int[]{5,3,4,7})); // [7]
        print(bestSumRec(8, new int[]{2,3,5})); // [3,5]
        print(bestSumRec(8, new int[]{1,4,5})); // [4,4]
        //print(bestSumRec(100, new int[]{1,2,5,25})); // [25,25,25,25]

        //print(bestSum(7, new int[]{5,3,4,7})); // [7]
        //print(bestSum(8, new int[]{2,3,5})); // [3,5]
        //print(bestSum(8, new int[]{1,4,5})); // [4,4]
        print(bestSum(100, new int[]{1,2,5,25})); // [25,25,25,25]
    }


    // m = target sum
    // n = nums.length
    // T = O ( n ^ m ) S = O(m ^2)
    private static ArrayList bestSumRec(int targetSum, int[] nums) {
        if ( targetSum == 0) return new ArrayList();
        if ( targetSum < 0) return null;
        ArrayList<Integer> shortestCombination = null;
        for ( int num: nums){
            ArrayList<Integer> remainderCombination = bestSumRec(targetSum-num, nums);
            if ( remainderCombination != null){
                remainderCombination.add(num);
                if ( shortestCombination == null || shortestCombination.size() > remainderCombination.size()){
                    shortestCombination = remainderCombination;
                }
            }
        }
        return shortestCombination;
    }

    private static ArrayList bestSum ( int targetSum, int[] nums){
        Map<Integer, ArrayList<Integer>> memo = new HashMap<>();
        return bestSumMemoized(targetSum, nums, memo);
    }

    private static ArrayList bestSumMemoized(int targetSum, int[] nums, Map<Integer, ArrayList<Integer>> memo) {
        if ( memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if ( targetSum == 0) return new ArrayList();
        if ( targetSum < 0) return null;
        ArrayList<Integer> shortestCombination = null;
        for ( int num: nums){
            ArrayList<Integer> remainderCombination = bestSumMemoized(targetSum-num, nums, memo);
            if ( remainderCombination != null){
                ArrayList<Integer> tempCombination = new ArrayList<>(remainderCombination);
                tempCombination.add(num);
                if ( shortestCombination == null || shortestCombination.size() > tempCombination.size()){
                    shortestCombination = tempCombination;
                }
            }
        }
        memo.put(targetSum, shortestCombination);
        return shortestCombination;
    }
}
