package takeUForward.heaps;

public class P7HeapSort {
    public void heapSort(int[] nums) {
        buildMaxHeap(nums);
        int last = nums.length-1;
        while ( last > 0){
            swap(nums, 0, last);
            last--;
            if ( last > 0){
                heapifyDown(nums, last, 0);
            }
        }
    }

    private void heapifyDown(int[] nums, int last, int ind) {
        int largest = ind;
        int left = 2 * ind+1;
        int right = 2 *ind+2;
        if ( left <= last && nums[left] > nums[largest]){
            largest= left;
        }
        if ( right <= last && nums[right] > nums[largest]){
            largest = right;
        }
        if ( ind != largest){
            swap(nums, ind, largest);
            heapifyDown(nums, last, largest);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void buildMaxHeap(int[] nums) {
        int n = nums.length;
        for ( int i=n/2-1; i>=0; i--){
            heapifyDown(nums, n-1, i);
        }
    }
}
