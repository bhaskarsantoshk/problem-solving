package striver_sde_sheet.arrays;

class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if ( nums == null || nums.length == 0) return -1;
        int slow = nums[0];
        int fast = nums[nums[0]];

        while ( slow != fast ){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while ( slow != fast ){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
