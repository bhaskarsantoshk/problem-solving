package takeUForward.recursion;

import java.util.ArrayList;
import java.util.List;

public class L13PrintAllPermutationsOfAStringArrayRecursionApproach2 {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        permute(0, nums, result);
        return result;
    }

    private void permute(int index, int[] nums, List<List<Integer>> result) {
        if ( index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for ( int num: nums) temp.add(num);
            result.add(temp);
            return;
        }

        for ( int i=index; i < nums.length; i++){
            swap(nums, i, index);
            permute(index+1, nums, result );
            swap( nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
