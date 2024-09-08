package takeUForward.recursion;

import java.util.ArrayList;
import java.util.List;

public class L10SubsetSumI {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> subsetSumsList = new ArrayList<>();
        subsetSums(0, 0, nums, subsetSumsList);
        return subsetSumsList;
    }

    private void subsetSums(int index, int sum, int[] nums, List<Integer> subsetSumsList) {
        if ( index >= nums.length){
            subsetSumsList.add(sum);
            return;
        }

        subsetSums(index+1, sum+ nums[index], nums, subsetSumsList);
        subsetSums(index+1, sum, nums, subsetSumsList);
    }
}
