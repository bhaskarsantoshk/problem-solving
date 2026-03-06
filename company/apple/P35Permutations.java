package company.apple;

import java.util.ArrayList;
import java.util.List;

public class P35Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        permute(nums, new ArrayList<>(), result, vis);
        return result;
    }

    private void permute(int[] nums, ArrayList<Integer> cur, List<List<Integer>> result, boolean[] vis) {
        if ( cur.size() >= nums.length){
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i=0; i<nums.length; i++){
            if (!vis[i]){
                vis[i] = true;
                cur.add(nums[i]);
                permute(nums, cur, result, vis);
                cur.remove(cur.size()-1);
                vis[i] = false;
            }
        }
    }
}

/*
 _ _ _ ( 1 2 3 )


 */
