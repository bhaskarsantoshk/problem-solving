package takeUForward.recursion;

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

    public List<List<Integer>> permuteWithoutExtraSpace(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteWithoutExtraSpace(0, nums, res);
        return res;
    }

    private void permuteWithoutExtraSpace(int index, int[] nums, List<List<Integer>> res) {
       if ( index == nums.length){
           List<Integer> list = new ArrayList<>();
           for ( int i=0; i<nums.length; i++){
               list.add(nums[i]);
           }
           res.add(new ArrayList<>(list));
           return;
       }

       for ( int i=index; i<nums.length; i++){
           swap(nums, i, index);
           permuteWithoutExtraSpace(index+1, nums, res);
           swap(nums, i, index );
       }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
