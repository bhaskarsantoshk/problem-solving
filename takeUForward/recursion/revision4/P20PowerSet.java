package takeUForward.recursion.revision4;

import java.util.ArrayList;
import java.util.List;

public class P20PowerSet {
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f( 0, new ArrayList<Integer>(), nums, ans );
        return ans;
    }

    private void f(int index, ArrayList<Integer> list, int[] nums, List<List<Integer>> ans) {
        if ( index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        f(index+1, list, nums, ans);
        list.remove(list.size()-1);
        f(index+1, list, nums, ans);
    }
}
