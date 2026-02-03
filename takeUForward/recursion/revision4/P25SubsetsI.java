package takeUForward.recursion.revision4;

import java.util.ArrayList;
import java.util.List;

public class P25SubsetsI {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> result = new ArrayList<>();
        subsetSums(nums, 0, 0, result);
        return result;
    }

    private void subsetSums(int[] nums, int index, int sum, List<Integer> result) {
        if ( index == nums.length){
            result.add(sum);
            return;
        }
        subsetSums(nums, index+1, sum+ nums[index], result);
        subsetSums(nums, index+1, sum, result);
    }
}
