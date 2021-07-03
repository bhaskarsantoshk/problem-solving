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

    public static void main(String[] args) {
        int result =smallestSubArraySumGreaterThanOrEqualToGivenSum(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = smallestSubArraySumGreaterThanOrEqualToGivenSum(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = smallestSubArraySumGreaterThanOrEqualToGivenSum(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}

// [2, 1, 5, 2, 3, 2]

// 7
// 2
// 2
