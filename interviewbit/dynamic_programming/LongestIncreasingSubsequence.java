package interviewbit.dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String args[]){
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int arr[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
        int result = lis.longestSubsequenceDPNSquare(arr);
        int result1 = lis.longestSubsequenceRecursive(arr);
        System.out.println(result);
        System.out.println(result1);
    }

    private int longestSubsequenceRecursive(int[] arr) {
        return lengthOfLIS(arr, Integer.MIN_VALUE, 0);
    }

    private int lengthOfLIS(int[] arr, int prev, int index) {
        if ( index == arr.length ){
            return 0;
        }
        int taken = 0;
        if ( arr[index] > prev ){
            taken = 1 + lengthOfLIS(arr, arr[index], index + 1);
        }
        int nottaken = lengthOfLIS(arr, prev, index+ 1);
        return Math.max ( taken, nottaken);
    }

    private int longestSubsequenceDPNSquare(int[] arr) {
        if ( arr == null || arr.length == 0 ){
            return 0;
        }
        int lis[] = new int[arr.length];
        Arrays.fill(lis, 1);
        int max = 1;
        for ( int i = 0; i < arr.length ; i++ ){
            for ( int j= 0; j <= i ; j++ ){
                if ( arr[i] > arr[j] && lis[j] + 1 > lis[i]){
                    lis[i] = lis[j] + 1;
                    max = Math.max ( max, lis[i]);
                }
            }
        }
        return max;
    }
}
