package striver_sde_sheet.stacks_and_queues;

public class P26RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if ( nums == null || nums.length == 0) return 0;
        int index = 1;
        for ( int i=1; i<nums.length; i++){
            if ( nums[i] != nums[i-1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
