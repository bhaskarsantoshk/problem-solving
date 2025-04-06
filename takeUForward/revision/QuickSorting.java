package takeUForward.revision;

public class QuickSorting {
    public int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if ( low < high){
            int partitionIndex = findPartition(nums, low, high);
            quickSort(nums, low, partitionIndex-1);
            quickSort(nums, partitionIndex+1, high);
        }
    }

    private int findPartition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low, j= high;
        while ( i < j){
            while ( i<= high && nums[i] <= pivot) i++;
            while( j>= low && nums[j] > pivot) j--;
            if ( i < j) swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
