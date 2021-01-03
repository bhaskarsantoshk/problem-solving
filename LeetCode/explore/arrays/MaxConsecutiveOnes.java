package LeetCode.explore.arrays;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for ( int num: nums){
            if (num == 1){
                count++;
            }
            else{
                count = 0;
            }
            max = Math.max(count, max);
        }
        return max;
    }

}