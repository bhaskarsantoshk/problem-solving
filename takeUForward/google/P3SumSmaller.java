package takeUForward.google;

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
}
