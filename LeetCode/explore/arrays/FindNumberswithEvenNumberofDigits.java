package LeetCode.explore.arrays;

public class FindNumberswithEvenNumberofDigits {
    public int findNumbers(int[] nums) {
        int res = 0;
        for ( int num: nums){
            int count = 0;
            while ( num!= 0){
                count++;
                num/=10;
            }
            if (count %2 == 0){
                res++;
            }
        }
        return res;
    }
}