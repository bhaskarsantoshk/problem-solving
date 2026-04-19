package takeUForward.striver79;

import java.util.*;

public class P2ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        for ( int i=0; i<nums.length-2; i++){
            for ( int j=i+1; j<nums.length-1; j++){
                for ( int k=j+1; k<nums.length; k++){
                    if ( nums[i] + nums[j] + nums[k] == 0){
                        int[] temp = {nums[i], nums[j], nums[k]};
                        Arrays.sort(temp);
                        set.add(Arrays.asList(temp[0], temp[1], temp[2]));
                    }
                }
            }
        }
        ans.addAll(new ArrayList<>(set));
        return ans;
    }
}
