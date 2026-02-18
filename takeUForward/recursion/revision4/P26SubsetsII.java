package takeUForward.recursion.revision4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P26SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // generate all subsets , sort, put into set, convert to list and return
        // bruteforce long process
        // better way is to sort the array, while creating subsets , avoid alreday taken subsets
        // when you say no to a number at a point, never take the number again
        // at one path, you must have taken that number so taking it again won't generate unique sets
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generate(nums, 0, result, new ArrayList<Integer>());
        return result;
    }

    private void generate(int[] nums, int i, List<List<Integer>> result, ArrayList<Integer> cur) {
        if ( i >= nums.length){
            result.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        generate(nums, i+1, result, cur);
        cur.remove(cur.size()-1);
        int index = i+1;
        for ( int j=i+1; j<nums.length; j++){
            if ( nums[i] != nums[j]) {
                generate(nums, j , result, cur);
                return;
            }
        }
        generate(nums, nums.length, result, cur);
    }
}
