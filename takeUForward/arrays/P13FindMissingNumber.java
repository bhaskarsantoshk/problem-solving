package takeUForward.arrays;

public class P13FindMissingNumber {
    public int missingNumber(int[] nums) {
        // Bruteforce
        // check from 0-n , iterate over the array and check if it exists, if not, that is the answer
        // T:O(N^2)

        // Better
        // create a hash array of N+1, update its index to 1 for each number
        // which ever doesn't have 1, will be the answer
        // T:O(N), S:O(N)

        // Optimal 1
        // sum = n+(n-1)/2;
        // sum -array sum will be the answer.

//        int sum = 0;
//        for ( int num: nums) sum += num;
//        int n = nums.length;
//        int naturalSum = (n*(n+1))/2;
//        return naturalSum-sum;

        // Optimal 2
        // Using XOR
        // XOR (arr) ^ XOR(0..n) - the missing one will be left

        int xor = 0;
        for ( int num: nums) xor ^= num;
        int n = nums.length;
        for ( int i=0; i<=n; i++) xor ^= i;
        return xor;
    }
}
