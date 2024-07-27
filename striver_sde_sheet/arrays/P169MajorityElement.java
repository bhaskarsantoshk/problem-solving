package striver_sde_sheet.arrays;

public class P169MajorityElement {

    /**
     * Brute Force Approach:
     * - Count all occurrences of each element and return the majority element if there is any.
     * - Time Complexity: O(n^2)
     *
     * Better Approach:
     * - Use a HashMap to store the frequency of each element.
     * - Time Complexity: O(N)
     * - Space Complexity: O(N)
     *
     * Optimal Approach (Moore's Voting Algorithm):
     * - Hypothetically consider one element as the majority element and increase its count.
     * - If another set of elements appear, reduce the count.
     * - If the count becomes 0, it indicates that there are enough elements that canceled out the current majority element.
     * - The algorithm guarantees that if there is a majority element, it will not be canceled out by the time we reach the end.
     * - Note: This algorithm assumes that a majority element always exists. We must double-check at the end to confirm.
     *
     * @param nums Array of integers.
     * @return Majority element if it exists, otherwise -1.
     */
    public int majorityElement(int[] nums) {
        int majorityElement = nums[0], count = 0;

        // Phase 1: Finding the candidate for majority element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majorityElement) {
                count++;
            } else {
                count--;
            }

            // Reset majorityElement when count reaches 0
            if (count == 0) {
                majorityElement = nums[i];
                count = 1;
            }
        }

        // Phase 2: Verify the candidate
        count = 0;
        for (int num : nums) {
            if (num == majorityElement) count++;
        }

        // Return the majority element if count is more than half of the array size
        return (count > nums.length / 2) ? majorityElement : -1;
    }
}
