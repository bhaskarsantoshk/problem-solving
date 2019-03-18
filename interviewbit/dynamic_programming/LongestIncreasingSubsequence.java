package interviewbit.dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String args[]){
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int arr[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
        int result = lis.longestSubsequenceDP(arr);
        int result1 = lis.longestSubsequenceRecursive(arr);
        System.out.println(result);
        System.out.println(result1);
    }

    private int longestSubsequenceRecursive(int[] arr) {
        return 0;
    }

    private int longestSubsequenceDP(int[] arr) {
        int res[] = new int[arr.length];
        int result = 0;
        Arrays.fill(arr,1);
        for(int i=1 ; i<arr.length ; i++){
            for(int j=0; j<i ; j++){
                if(arr[i] > arr[j] && res[j]+1 > res[i]){
                    res[i] = res[j]+1;
                    result = Math.max(res[i], result);
                }
            }
        }
        return result;
    }
}
