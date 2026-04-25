package takeUForward.striver79;

import java.util.ArrayList;
import java.util.List;

public class P4MajorityElementII {
    public List<Integer> majorityElementTwo(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for ( int i=0; i<nums.length; i++){
            if ( list.isEmpty() || list.get(0) != nums[i]){
                int count = 0;
                for ( int j=0; j <nums.length; j++) if ( nums[i] == nums[j]) count++;
                if ( count > nums.length/3) list.add(nums[i]);
            }
            if ( list.size() == 2) break;
        }
        return list;
    }
}
