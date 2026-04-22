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


    public List<List<Integer>> threeSumBetter(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Set<Integer> numSet;
        for ( int i=0; i<nums.length-1; i++){
            numSet = new HashSet<>();
            for ( int j=i+1; j<nums.length; j++){
                int third = -(nums[i] + nums[j]);
                if ( numSet.contains(third)){
                    int[] temp = {nums[i], nums[j], third};
                    Arrays.sort(temp);
                    set.add(Arrays.asList(temp[0], temp[1], temp[2]));
                }
                numSet.add(nums[j]);
            }
        }
        ans.addAll(new ArrayList<>(set));
        return ans;
    }

    public List<List<Integer>> threeSumOptimized(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        Arrays.sort(nums);
        for ( int i=0; i<nums.length; i++){
            if ( i > 0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = nums.length-1;

            while ( j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if ( sum < 0){
                    j++;
                } else if ( sum > 0){
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(new ArrayList<>(temp));
                    j++;
                    k--;
                    while ( j < k && nums[j] == nums[j-1]) j++;
                    while ( j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
}
