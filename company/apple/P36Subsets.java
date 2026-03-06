package company.apple;

import java.util.ArrayList;
import java.util.List;

public class P36Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        f(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void f(int[] nums, int index, ArrayList<Integer> cur, List<List<Integer>> result) {
        if ( index >= nums.length){
            result.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        f(nums, index+1, cur, result);
        cur.remove(cur.size()-1);
        f(nums, index+1, cur, result);
    }
}
