package takeuForward.recursion;

import java.util.ArrayList;
import java.util.List;

public class P46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean map[] = new boolean[nums.length];
        permute(nums, res, new ArrayList<Integer>(), map);
        return res;
    }

    private void permute(int[] nums, List<List<Integer>> res, ArrayList<Integer> list, boolean[] map) {
        if ( list.size() == nums.length ) {
            res.add(new ArrayList<>(list));
            return;
        }
        for ( int i=0; i<nums.length; i++){
            if ( !map[i] ){
                map[i] = true;
                list.add(nums[i]);
                permute(nums, res, list, map);
                list.removeLast();
                map[i] = false;
            }
        }
    }
}
