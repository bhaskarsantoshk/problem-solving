package data_structures.arrays;

public class MaximumSumSubArraySizeK {
    public static int getMaxSumSubArraySizeK(int[] a, int k){
        int maxSum = 0, sum=0;
        for ( int i=0; i<k; i++){
            maxSum+= a[i];
        }
        int index = 0;
        for ( int i=k; i<a.length; i++){
            sum = sum-a[index++]+a[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
