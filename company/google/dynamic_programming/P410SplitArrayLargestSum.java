package company.google.dynamic_programming;

public class P410SplitArrayLargestSum {
    public int splitArrayBruteForce(int[] nums, int k) {
        if ( nums.length < k) return -1;
        int maxElementInArray = 0, sum = 0;
        for ( int i=0; i<nums.length; i++){
            maxElementInArray = Math.max(nums[i], maxElementInArray);
            sum += nums[i];
        }

        int start = maxElementInArray, end = sum;
        for ( int minSum=start; minSum<=end; minSum++){
            int allocatedSubArrays = countAllocatedSubArrays(nums, minSum);
            if ( allocatedSubArrays == k) return minSum;
        }
        return -1;
    }

    private int countAllocatedSubArrays(int[] nums, int maxSum) {
        int countOfSubArrays = 1;
        int subArraySum = 0;
        for ( int i=0; i<nums.length; i++){
            if ( subArraySum + nums[i] <= maxSum){
                subArraySum += nums[i];
            } else {
                subArraySum = nums[i];
                countOfSubArrays++;
            }
        }
        return countOfSubArrays;
    }

    public int splitArrayBinarySearch(int[] nums, int k) {
        if ( nums.length < k) return -1;
        int maxElementInArray = 0, sum = 0;
        for ( int i=0; i<nums.length; i++){
            maxElementInArray = Math.max(nums[i], maxElementInArray);
            sum += nums[i];
        }

        int start = maxElementInArray, end = sum;
        while ( start <= end ){
            int mid = start + (end-start)/2;
            int countSubArrays = countAllocatedSubArrays(nums, mid);
            if ( countSubArrays <= k){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}
