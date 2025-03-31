package takeUForward.recursion.revision;

import java.util.ArrayList;
import java.util.Collections;

public class P18SubsetSum {
    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        findSubsets(num, 0, 0, ans);
        Collections.sort(ans);
        return ans;
    }

    private static void findSubsets(int[] nums, int index, int sum, ArrayList<Integer> ans) {
        if ( index == nums.length){
            ans.add(sum);
            return;
        }
        findSubsets(nums, index+1, sum+nums[index], ans);
        findSubsets(nums, index+1, sum, ans);
    }
}
