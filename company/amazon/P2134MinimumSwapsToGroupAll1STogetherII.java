package company.amazon;

public class P2134MinimumSwapsToGroupAll1STogetherII {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;

        // Count total number of 1's
        for (int num : nums) {
            totalOnes += num;
        }

        // Edge cases
        if (totalOnes == 0 || totalOnes == n) return 0;

        int currentOnes = 0;

        // Count 1's in the first window of size totalOnes
        for (int i = 0; i < totalOnes; i++) {
            currentOnes += nums[i];
        }

        int maxOnes = currentOnes;
        for ( int i=0; i<n; i++){
            currentOnes -= nums[i];
            currentOnes += nums[(i+totalOnes)%n];
            maxOnes = Math.max(maxOnes, currentOnes);
        }
        return totalOnes - maxOnes;
    }
}
