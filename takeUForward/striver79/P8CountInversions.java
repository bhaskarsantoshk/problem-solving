package takeUForward.striver79;

public class P8CountInversions {
    public long numberOfInversions(int[] nums) {
        int count = 0;
        for ( int i=0; i<nums.length; i++){
            for ( int j=i+1; j<nums.length; j++){
                if ( nums[i] > nums[j]) count++;
            }
        }
        return count;
    }
}
