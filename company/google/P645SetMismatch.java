package company.google;

public class P645SetMismatch {

    // all integers arr 1 to n ( nums.length)
    // iterate over 1 to n, find the count and update the result array
    // T = O(N^2)
    public int[] findErrorNumsBruteForce(int[] nums) {
        int []res = new int[2];
        for ( int num = 1; num <= nums.length; num++){
            int count = 0;
            for ( int i=0; i<nums.length; i++){
                if ( nums[i] == num ) count++;
            }
            if ( count == 2) res[0] = num; // repeat number
            if ( count == 0) res[1] = num; // missing number
        }
        return res;
    }

    // reduce time complexity to O(N) using hashing
    // Space O(N)
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length+1];
        for ( int num: nums){
            count[num]++;
        }
        int missing = -1, repeat = -1;
        // zero's count will be zero, make sure to skip it
        for ( int num: count){
            if (count[num] == 2) repeat = num;
            if ( count[num] == 0) missing = num;
            // small optimization
            if ( repeat != -1 && missing != -1) break;
        }
        return new int[]{repeat, missing};
    }
}
