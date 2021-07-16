package LeetCode.explore.top_interview_questions.easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int result = 0;
        for ( int num: nums ){
            result ^= num;
        }
        for ( int i=1; i<= nums.length; i++){
            result ^= i;
        }
        return result;
    }
}
