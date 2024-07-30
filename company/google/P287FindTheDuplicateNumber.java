package company.google;

import java.util.Arrays;

public class P287FindTheDuplicateNumber {

    // T = O(N log N)
    public int findDuplicateBruteForce(int[] nums) {
        Arrays.sort(nums);
        for ( int i=1; i<nums.length; i++){
            if ( nums[i] == nums[i-1]) return nums[i];
        }
        return 0;
    }

    // problem says range of [1,n] & nums.length = n+1
    // T O(N) & Space O(N)
    public int findDuplicateLinear(int[] nums) {
       int count[] = new int[nums.length];
       for ( int num: nums){
           count[num]++;
           if ( count[num] > 1) return num;
       }
       return 0;
    }

    // Most optimal will use LinkedList Cycle method
    // T O(N), S O(1)
    public int findDuplicate(int[] nums) {
        if ( nums == null || nums.length < 2) return 0;
        int slow = nums[0], fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while( slow != fast);
        slow = nums[0];
        while ( slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
