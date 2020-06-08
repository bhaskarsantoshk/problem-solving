package LeetCode;

public class P1295FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int res = 1;

        for ( int num: nums ){
            int len = 0;
            while ( num != 0){
                num/=10;
                len++;
            }
            if ( len % 2 == 0){
                res++;
            }
        }
        return res;
    }
}
