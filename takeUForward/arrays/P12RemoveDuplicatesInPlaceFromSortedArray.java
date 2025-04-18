package takeUForward.arrays;

public class P12RemoveDuplicatesInPlaceFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // Brute force -> add it to set, return set.size()
        // since we need to update nums array - use LinkedHashSet to preserve order
        // T: N log N, s: O(N)

        // Optimal - 2 pointer
        // let first element stay, while iterating from next,
        // iterate with i, update nums[index]=nums[i] only if nums[i] != nums[i-1], index++
        int n = nums.length, index=1;
        for ( int i=1; i<n; i++){
            if (nums[i] != nums[i-1]) nums[index++] = nums[i];
        }
        for ( int i=index; i<n; i++){
            nums[i] = 0;
        }
        return index;
    }
}
