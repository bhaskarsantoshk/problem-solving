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


    public int majorityElementI(int[] nums) {
        int element =-1;
        int count = 0;
        for ( int i=0; i<nums.length; i++){
            if ( count == 0){
                element = nums[i];
                count = 1;
            } else if ( element == nums[i]) count++;
            else count--;
        }

         count =0;
        for ( int i=0; i<nums.length; i++){
            if ( element == nums[i]) count++;
        }
        if ( count > nums.length/2) return element;
        return -1;
    }

    public List<Integer> majorityElementTwoOptimal(int[] nums) {
        List<Integer> res = new ArrayList<>();
        return res;
    }
}
