package takeUForward.google;

import java.util.Arrays;

public class P3SumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
       int count = 0;
       for ( int i=0; i < nums.length-2; i++){
           for ( int j=i+1; j<nums.length-1; j++){
               for ( int k=j+1; k<nums.length; k++){
                   if ( nums[i] + nums[j] + nums[k] < target) count++;
               }
           }
       }
       return count;
    }

    public int threeSumSmallerTwoPointer(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for ( int i=0; i < nums.length-2; i++){
            int l = i+1, r = nums.length-1;
            while ( l < r){
                if ( nums[i] + nums[l] + nums[r] < target){
                    count+= r-l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return count;
    }
}
