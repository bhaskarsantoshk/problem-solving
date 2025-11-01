package takeUForward.QR;

import java.util.ArrayList;
import java.util.List;

public class P4MajorityElementII {
    public List<Integer> majorityElementTwo(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for ( int i=0; i<nums.length; i++){
            if ( res.isEmpty() || res.get(0) != nums[i]){
                int count = 0;
                for ( int j=0; j<nums.length; j++){
                    if ( nums[i] == nums[j]) count++;
                }
                if ( count > nums.length/3) res.add(nums[i]);
            }
            if ( res.size() == 2) break;
        }
        return res;
    }
}
