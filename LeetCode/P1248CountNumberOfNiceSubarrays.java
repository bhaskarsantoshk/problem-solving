package LeetCode;

public class P1248CountNumberOfNiceSubarrays {
    public int numberOfSubarraysBruteForce(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int odd = 0;
                for ( int index=i; index <=j; index++) {
                    if (nums[j] % 2 == 0) {
                        odd += 1;
                    }
                }
                if (odd == k) {
                    count++;
                }
            }
        }
        return count;
    }

   // Pre-reqs: Longest Subarray with sum K

    public int[] longestSubarrayWithSumK(int[] nums, int k) {
        int start = 0, end = 0, length = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                int sum = 0;
                for ( int index=i; index <=j; index++) {
                    sum+= nums[index];
                }
                if (sum == k && length < j - i) {
                    length = j-i;
                    start = i;
                    end = j;
                }
            }
        }
        return new int[]{start, end};
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] %=2;
        }
        return count;
    }

}
