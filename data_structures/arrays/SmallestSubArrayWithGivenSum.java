package data_structures.arrays;

public class SmallestSubArrayWithGivenSum {
    public static int smallestSubArraySumGreaterThanOrEqualToGivenSum( int sum, int[] nums){
        int windowSize = 0, currentSum=0, minWindowSize=Integer.MAX_VALUE, index=0;
        for ( int i=0; i<nums.length; i++){
            currentSum+= nums[i];
            windowSize++;
            while ( currentSum >= sum ){
                minWindowSize = Math.min(minWindowSize, windowSize);
                currentSum-= nums[index++];
                windowSize--;
            }
        }
        return minWindowSize != Integer.MAX_VALUE ? minWindowSize: -1;
    }
}

