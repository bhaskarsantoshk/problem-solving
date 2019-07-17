package LeetCode;

public class P1004MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int start = 0, max=0, zero=0;
        for ( int end = 0; end< A.length; end++){
            if  ( A[end] == 0){
                zero++;
            }
            while ( zero > K){
                if ( A[start] == 0){
                    zero--;
                }
                start ++;
            }
            max = Math.max ( end-start+1, max);
        }
        return max;
    }
}
