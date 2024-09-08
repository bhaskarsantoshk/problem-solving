package takeUForward.recursion;

import java.util.ArrayList;
import java.util.List;

public class L12PrintAllPermutationsOfAStringArrayRecursionApproach1 {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int [] freq = new int[nums.length];
        permute(nums, result, freq, new ArrayList<Integer>());
        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, int[] freq, ArrayList<Integer> list) {
        if ( list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for ( int i=0; i<nums.length; i++){
            if ( freq[i] == 0){
                freq[i] = 1;
                list.add(nums[i]);
                permute(nums, result, freq, list);
                freq[i] = 0;
                list.remove(list.size()-1);
            }
        }
    }
}
