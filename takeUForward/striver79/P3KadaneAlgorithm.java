package takeUForward.striver79;

public class P3KadaneAlgorithm {

    public int maxSubArrayBruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        for ( int i=0; i<nums.length; i++){
            for ( int j=0; j<nums.length; j++){
                int sum = nums[i];
                for ( int k=i+1; k<=j; k++) sum += nums[k];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public int maxSubArrayBetter(int[] nums) {
        int max = Integer.MIN_VALUE;
        for ( int i=0; i<nums.length; i++){
            int sum = nums[i];
            max = Math.max(max, sum);
            for ( int j=i+1; j<nums.length; j++){
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public int maxSubArrayOptimal(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for ( int i=1; i<nums.length; i++){
            sum = Math.max(nums[i], sum+ nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public int maxSubArrayOptimalFollowUp(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        int start = 0;
        int tempStart = 0;
        int end = 0;
        for ( int i=1; i<nums.length; i++){
            if ( nums[i] > sum + nums[i]){
                sum = nums[i];
                tempStart = i;
            } else {
                sum = sum+ nums[i];
            }
           if ( sum > max){
               max = sum;
               start = tempStart;
               end = i;
           }
        }
        return max;
    }
}
