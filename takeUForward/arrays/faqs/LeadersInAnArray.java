package takeUForward.arrays.faqs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInAnArray {
    public List<Integer> leaders(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int maxSoFar = Integer.MIN_VALUE;
        for ( int i= nums.length-1; i>=0; i--){
            if ( nums[i] > maxSoFar){
                maxSoFar = nums[i];
                res.add(nums[i]);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
