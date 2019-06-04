package LeetCode;

public class P912SortanArray {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length-1);
        return nums;
    }

    private void quicksort(int[] nums, int start, int end) {
        if ( start < end ){
            int partitionIndex = partition(nums, start, end);
            quicksort(nums, start, partitionIndex-1);
            quicksort(nums, partitionIndex+1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int partitionIndex = 0;
        int pivot = nums[end];
        for(int i= start ; i< end ; i++){
            if ( nums[i] < pivot ){
                swap ( nums, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(nums, partitionIndex, end);
        return partitionIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
