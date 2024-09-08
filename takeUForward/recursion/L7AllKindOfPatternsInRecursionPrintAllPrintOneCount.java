package takeUForward.recursion;

import java.util.ArrayList;
import java.util.List;

public class L7AllKindOfPatternsInRecursionPrintAllPrintOneCount {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        return checkSubsequenceSum(0, nums, k);
    }

    private boolean checkSubsequenceSum(int index, int[] nums, int target) {
        if ( index >= nums.length){
            return target == 0;
        }
        boolean take = false;
        if ( nums[index] <= target){
            take = checkSubsequenceSum(index+1, nums, target-nums[index]);
            if (take) return true;
        }
        boolean notTake = checkSubsequenceSum(index+1, nums, target);
        return notTake;
    }


    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return countSubsequenceWithTargetSum(0, nums, k);
    }

    private int countSubsequenceWithTargetSum(int index, int[] nums, int target) {
        if ( index >= nums.length){
            if ( target == 0) return 1;
            else return 0;
        }

        int notTake = countSubsequenceWithTargetSum(index+1, nums, target);
        int take = 0;
        if ( target >= nums[index]){
            take = countSubsequenceWithTargetSum(index+1, nums, target-nums[index]);
        }
        return take+ notTake;
    }


    public boolean printAnySubsequenceSum(int[] nums, int k) {
        return printAnySubsequenceSum(0, nums, k, new ArrayList<>());
    }

    private boolean printAnySubsequenceSum(int index, int[] nums, int target, List<Integer> list) {
        if ( index >= nums.length){
            if ( target == 0) {
                System.out.println(list);
                return true;
            } else {
                return false;
            }
        }
        boolean notTake = printAnySubsequenceSum(index+1, nums, target, list);
        if ( notTake ) return true;
        boolean take = false;
        if ( nums[index] <= target){
            list.add(nums[index]);
            take = printAnySubsequenceSum(index+1, nums, target-nums[index], list);
            if ( take ) return true;
            list.remove(list.size()-1);
        }
        return false;
    }

    public static void main(String [] args){
        L7AllKindOfPatternsInRecursionPrintAllPrintOneCount obj = new L7AllKindOfPatternsInRecursionPrintAllPrintOneCount();
        int []nums= {1, 2, 3, 4, 5};
        int target = 8;
        obj.printAnySubsequenceSum(nums, target);
    }
}
