package takeUForward.heaps.revision;

public class HeapSort {
    public void heapSort(int[] nums) {
        buildMaxHeap(nums);
        int last = nums.length-1;
        while ( last > 0){
            swap(nums, 0, last);
            last--;
            if(last > 0){
                heapifyDown(nums, 0, last);
            }
        }
    }

    private void buildMaxHeap(int[] nums) {
        int n = nums.length;
        for ( int ind = n/2-1; ind >=0 ; ind--){
            heapifyDown(nums, ind, n-1);
        }
    }

    private void heapifyDown(int[] nums, int ind, int last) {
        int largest = ind;
        int left = 2 * ind+1;
        int right = 2 * ind+2;

        if ( left <= last && nums[left] > nums[largest]){
            largest = left;
        }
        if ( right <= last && nums[right] > nums[largest]){
            largest = right;
        }
        if ( ind != largest){
            swap(nums, ind, largest);
            heapifyDown(nums, largest, last);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j] = temp;
    }
}
